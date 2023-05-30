package com.quickmall.orderservice.controller;

import com.quickmall.orderservice.entity.OmsOrderItem;
import com.quickmall.orderservice.model.OmsOrderItemRequest;
import com.quickmall.orderservice.model.OmsOrderItemResponse;
import com.quickmall.orderservice.model.OmsOrderRequest;
import com.quickmall.orderservice.service.OrderItemService;
import lombok.extern.log4j.Log4j2;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/order/v1/orderItems")
@RestController
@Log4j2

public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping
    public ResponseEntity<OmsOrderItemResponse> saveOrderItem(@RequestBody OmsOrderItemRequest request) {
        var response = orderItemService.saveOrderItem(request);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public List<OmsOrderItem> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }

    @GetMapping("/{orderItemId}")
    public ResponseEntity<OmsOrderItemResponse> getOrderItemById(@PathVariable("orderItemId") Long orderItemId) {
        var response = orderItemService.getOrderItemById(orderItemId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
