package com.quickmall.orderservice.service;

import com.quickmall.orderservice.entity.OmsOrderItem;
import com.quickmall.orderservice.model.CartItem;
import com.quickmall.orderservice.model.OmsOrderItemRequest;
import com.quickmall.orderservice.model.OmsOrderItemResponse;
import com.quickmall.orderservice.model.OmsOrderRequest;

import java.util.List;

public interface OrderItemService {

    OmsOrderItemResponse saveCartItem(CartItem cartItem);

//    OmsOrderItemResponse saveOrderItem(OmsOrderItemRequest request);

//    List<OmsOrderItem> getAllOrderItems();

//    OmsOrderItemResponse getOrderItemById(Long orderItemId);
}
