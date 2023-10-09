package com.quickmall.orderservice.service.impl;

import com.quickmall.orderservice.constant.OrderStatus;
import com.quickmall.orderservice.constant.PayType;
import com.quickmall.orderservice.constant.ReceiptType;
import com.quickmall.orderservice.entity.OmsOrder;
import com.quickmall.orderservice.entity.OmsOrderItem;
import com.quickmall.orderservice.external.client.CartFeignService;
import com.quickmall.orderservice.external.client.PaymentFeginService;
import com.quickmall.orderservice.external.client.ProductFeignService;
import com.quickmall.orderservice.model.*;
import com.quickmall.orderservice.repository.OrderRepository;
import com.quickmall.orderservice.service.OrderItemService;
import com.quickmall.orderservice.service.OrderService;
import lombok.extern.log4j.Log4j2;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@Log4j2

public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartFeignService cartFeignService;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private StringRedisTemplate strRedisTemp;

    @Autowired
    private ProductFeignService productFeignService;

    @Autowired
    private PaymentFeginService paymentFeginService;

    /**
     * save order from the selected Item in the Cart
     * @param orderRequest
     */
    public void saveOrderByCart(OmsOrderRequest orderRequest, String authHeader) {

        // orderSn
        Long orderSn = new Random().nextLong();
        // referenceNumber
        String referenceNumber = String.valueOf(new Random().nextLong());

        // get order items in cart
        List<CartItem> cartItemList = cartFeignService.getSelectedItems(authHeader).getBody();
        log.info("cartItemList:" + cartItemList);

        List<OmsOrderItemResponse> orderItemList = cartFeignService.getSelectedItems(authHeader).getBody()
                .stream()
                .map(orderItemService::saveCartItem)
                .collect(Collectors.toList());

        log.info("orderItemList:" + orderItemList);

        // set order price
        BigDecimal price = orderItemList.stream()
                .map(orderItem -> orderItem.getSkuPrice())
                .reduce(BigDecimal::add)
                .get();

        log.info("total price:" + price);

        // save order
        OmsOrder order = OmsOrder.builder()
                .orderSn(orderSn)
                .totalAmount(price)
                .payAmount(price)
                .payType(PayType.CreditCard)
                .orderStatus(OrderStatus.PREPARING)
                .note(orderRequest.getNote())
                .orderCreateTime(new Date())
                .paymentTime(new Date())
                .deliveredTime(new Date())
                .isConfirm(1)
                .confirmTime(new Date())
                .receiptType(ReceiptType.ONLINE_RECEIPT)
                .build();

        /**
         * 2. product service -> block product(reduce the quantity)
         */
        cartItemList.forEach(skuItem -> productFeignService.reduceQuantity(skuItem.getSkuId(), skuItem.getCount()));
        log.info("product quantity has been changed!");

        /**
         * 3. payment-service: make payment
         */
        PaymentRequest paymentRequest = PaymentRequest.builder()
                .orderId(order.getOrderId())
                .orderSn(order.getOrderSn())
                .payAmount(order.getPayAmount())
                .referenceNumber(referenceNumber)
                .payType(order.getPayType())
                .build();

        try {
            paymentFeginService.doPayment(paymentRequest);
            log.info("Payment DONE SUCCESFULLY!!!!! Order Status: PLACED");
            order.setOrderStatus(OrderStatus.ON_THE_WAY);
        } catch (Exception e) {
            log.error("Error order in the Payment !!!!");
            order.setOrderStatus(OrderStatus.FAILED);
        }

        /**
         * Save Order
         */
        orderRepository.save(order);

        log.info("order:" + order);

        OmsOrderResponse orderResponse = new OmsOrderResponse();
        copyProperties(order, orderResponse);

        log.info("orderResponse:" + orderResponse);
    }

//    /**
//     * submit order (without cart) v0.1
//     * Param: OmsOrderRequest request
//     */
//    @Override
//    public OmsOrderResponse saveOrder(OmsOrderRequest request) {
//        OmsOrder order = OmsOrder.builder()
//                .orderSn(new Random().nextLong())
//                .totalAmount(request.getTotalAmount())
//                .payAmount(request.getPayAmount())
//                .payType(PayType.CreditCard)
//                .orderStatus(OrderStatus.PREPARING)
//                .note(request.getNote())
//                .orderCreateTime(new Date())
//                .paymentTime(new Date())
////                .confirmTime(request.getConfirmTime())
////                .isConfirm(request.getIsConfirm())
////                .deliveredTime(request.getDeliveredTime())
//                .deliveredTime(new Date())
//                .isConfirm(1)
//                .confirmTime(new Date())
//                .receiptType(ReceiptType.ONLINE_RECEIPT)
//                .build();
//
//        orderRepository.save(order);
//
//        OmsOrderResponse response = new OmsOrderResponse();
//        copyProperties(order, response);
//
//        return response;
//    }

    @Override
    public List<OmsOrder> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public OmsOrderResponse getOrderById(Long orderId) {

        OmsOrder order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException(
                ));

        OmsOrderResponse response = new OmsOrderResponse();
        copyProperties(order, response);

        return response;
    }
}
