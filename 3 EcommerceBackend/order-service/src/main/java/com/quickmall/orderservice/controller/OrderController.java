package com.quickmall.orderservice.controller;

import com.quickmall.orderservice.entity.OmsOrder;
import com.quickmall.orderservice.model.OmsOrderRequest;
import com.quickmall.orderservice.model.OmsOrderResponse;
import com.quickmall.orderservice.service.OrderService;
import lombok.extern.log4j.Log4j2;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/order/v1/orders")
@RestController
@Log4j2

public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OmsOrderResponse> saveOrder(@RequestBody OmsOrderRequest request) {
        var respones = orderService.saveOrder(request);

        return new ResponseEntity<>(respones, HttpStatus.CREATED);
    }

    @GetMapping
    public List<OmsOrder> gerAllOrder(){
        return orderService.getAllOrder();
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OmsOrderResponse> getOrderById(@PathVariable("orderId") Long orderId) {
        var response = orderService.getOrderById(orderId);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
