package com.quickmall.orderservice.service;

import com.quickmall.orderservice.entity.OmsOrder;
import com.quickmall.orderservice.model.OmsOrderRequest;
import com.quickmall.orderservice.model.OmsOrderResponse;

import java.util.List;

public interface OrderService {
    OmsOrderResponse saveOrder(OmsOrderRequest request);

    List<OmsOrder> getAllOrder();

    OmsOrderResponse getOrderById(Long orderId);
}
