package com.quickmall.orderservice.service.impl;

import com.quickmall.orderservice.entity.OmsOrderItem;
import com.quickmall.orderservice.external.client.ProductFeignService;
import com.quickmall.orderservice.model.CartItem;
import com.quickmall.orderservice.model.OmsOrderItemRequest;
import com.quickmall.orderservice.model.OmsOrderItemResponse;
import com.quickmall.orderservice.model.PmsSpuResponse;
import com.quickmall.orderservice.repository.OrderItemRepository;
import com.quickmall.orderservice.repository.OrderRepository;
import com.quickmall.orderservice.service.OrderItemService;
import lombok.extern.log4j.Log4j2;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@Log4j2
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductFeignService productFeignService;

    @Autowired
    private OrderRepository orderRepository;

    /**
     * convert the selected items in Cart into items' orders
     * @param cartItem
     * @return
     */
    @Override
    public OmsOrderItemResponse saveCartItem(CartItem cartItem) {

        var skuId = cartItem.getSkuId();

        OmsOrderItemResponse orderItemResponse = new OmsOrderItemResponse();
        orderItemResponse.setSkuId(skuId);
        orderItemResponse.setCount(cartItem.getCount());
        orderItemResponse.setSkuPrice(cartItem.getPrice());

        /**
         * get Spu via SkuId;
         */
        var spu = productFeignService.getSpuBySkuId(skuId).getBody();
        orderItemResponse.setSpuId(spu.getSpuId());
        log.info("SPU Info: " + spu);

        /**
         * get Sku via SkuId
         */
        var sku = productFeignService.getSkuById(skuId).getBody();
        orderItemResponse.setSkuId(sku.getSkuId());

        return orderItemResponse;
    }

//    /**
//     * save order item without cart v0.1
//     * @param request
//     * @return
//     */
//    @Override
//    public OmsOrderItemResponse saveOrderItem(OmsOrderItemRequest request) {
//
//        log.info("getSkuId: " + request.getSkuId());
//
//        /**
//         * get Spu via SkuId;
//         */
//        var spu = productFeignService.getSpuBySkuId(request.getSkuId()).getBody();
//        log.info("SPU Info: " + spu + "  " + productFeignService.getSpuBySkuId(request.getSkuId()) );
//
//        /**
//         * get Sku via SkuId
//         */
//        var sku = productFeignService.getSkuById(request.getSkuId()).getBody();
//
//        /**
//         * get orderSn via orderId
//         */
//        Long orderSnNum = orderRepository.findById(request.getOrderId()).get().getOrderSn();
//
//        /**
//         * 1. generate orderItem
//         */
//        OmsOrderItem orderItem = OmsOrderItem.builder()
//                .orderId(request.getOrderId())
////                .orderSn(request.getOrderSn())
//                .orderSn(orderSnNum)
////              // setting spu info
////                .categoryId(request.getCategoryId())
////                .spuId(request.getSpuId())
////                .spuName(request.getSpuName())
////                .spuBrand(request.getSpuBrand())
//                .categoryId(spu.getCategoryId())
//                .spuId(spu.getSpuId())
//                .spuName(spu.getSpuName())
//                .spuBrand(spu.getBrandName())
//                // sku info need to entered by users
//                .skuId(request.getSkuId())
////                .skuPrice(request.getSkuPrice()
//                .skuPrice(sku.getPrice())
//                .skuQuantity(request.getSkuQuantity())
//                .attributeValueList("[{\"key\":\"color\",\"value\":\"pink\"},{\"key\":\"size\",\"value\":\"XS\"}]")
//                .build();
//
//        orderItemRepository.save(orderItem);
//
//        OmsOrderItemResponse response = new OmsOrderItemResponse();
//        copyProperties(orderItem, response);
//
//        /**
//         * 2. change the number of product
//         */
//
//
//        return response;
//    }

//    /**
//     * get all order items v1.0
//     * @return
//     */
//    @Override
//    public List<OmsOrderItem> getAllOrderItems() {
//        return orderItemRepository.findAll();
//    }

//    /**
//     * get Order Item By Id v1.0
//     * @param orderItemId
//     * @return
//     */
//    @Override
//    public OmsOrderItemResponse getOrderItemById(Long orderItemId) {
//
//        OmsOrderItem orderItem = orderItemRepository.findById(orderItemId)
//                .orElseThrow(() -> new RuntimeException());
//
//        OmsOrderItemResponse response = new OmsOrderItemResponse();
//        copyProperties(orderItem, response);
//
//        return response;
//    }
}
