package com.quickmall.orderservice.service.impl;

import com.quickmall.orderservice.constant.OrderStatus;
import com.quickmall.orderservice.constant.ReceiptType;
import com.quickmall.orderservice.entity.OmsOrder;
import com.quickmall.orderservice.model.OmsOrderRequest;
import com.quickmall.orderservice.model.OmsOrderResponse;
import com.quickmall.orderservice.repository.OrderRepository;
import com.quickmall.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public OmsOrderResponse saveOrder(OmsOrderRequest request) {
        OmsOrder order = OmsOrder.builder()
                .orderSn(new Random().nextLong())
                .totalAmount(request.getTotalAmount())
                .payAmount(request.getPayAmount())
                .payType(request.getPayType())
                .orderStatus(OrderStatus.PREPARING)
                .note(request.getNote())
                .orderCreateTime(new Date())
                .paymentTime(new Date())
//                .confirmTime(request.getConfirmTime())
//                .isConfirm(request.getIsConfirm())
//                .deliveredTime(request.getDeliveredTime())
                .deliveredTime(new Date())
                .isConfirm(1)
                .confirmTime(new Date())
                .receiptType(ReceiptType.ONLINE_RECEIPT)
                .build();

        orderRepository.save(order);

        OmsOrderResponse response = new OmsOrderResponse();
        copyProperties(order, response);

        return response;
    }

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
