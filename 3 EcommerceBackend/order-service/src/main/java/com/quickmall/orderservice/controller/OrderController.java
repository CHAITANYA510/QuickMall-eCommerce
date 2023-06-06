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

import javax.websocket.server.PathParam;
import java.util.List;

@RequestMapping("/api/order/v1/orders")
@RestController
@Log4j2

public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * v0.1 save order without cart : saveOrder()
     * v0.2 save order by cart : saveOrderByCart()
     *                           |--- can generate a new order based on the selected items in the cart,
     *                           |--- do not need to enter the product info in the ORDER-SERVICE like v0.1
     * @param orderRequest
     * @param cartId
     * @return
     */
    @PostMapping
    public ResponseEntity<OmsOrderResponse> saveOrder(@RequestBody OmsOrderRequest orderRequest, @PathParam("cartId") Long cartId) {
//        var respones = orderService.saveOrder(request);
        orderService.saveOrderByCart(orderRequest, cartId);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
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
