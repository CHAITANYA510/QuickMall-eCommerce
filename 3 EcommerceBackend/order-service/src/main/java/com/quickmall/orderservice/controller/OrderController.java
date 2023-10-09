package com.quickmall.orderservice.controller;

import com.quickmall.orderservice.constant.JWTConstant;
import com.quickmall.orderservice.entity.OmsOrder;
import com.quickmall.orderservice.model.OmsOrderRequest;
import com.quickmall.orderservice.model.OmsOrderResponse;
import com.quickmall.orderservice.service.OrderService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import javax.xml.bind.DatatypeConverter;
import java.util.List;

@RequestMapping("/api/order/v1/orders")
@RestController
@Log4j2
@Api("Order Info")

public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * v0.1 save order without cart : saveOrder() --> OrderItem
     * v0.2 save order by cart : saveOrderByCart()
     *                           |--- can generate a new order based on the selected items in the cart,
     *                           |--- do not need to enter the product info in the ORDER-SERVICE like v0.1
     * @param orderRequest
     * @param cartId
     * @return
     */
    @PostMapping
    @ApiOperation("save order by cart : saveOrderByCart() v2.0")
    public ResponseEntity<Void> saveOrder(@RequestBody OmsOrderRequest orderRequest,
                                          @RequestHeader(value = "Authorization") String authHeader) {

        // use the authHeader to call feign service(cart-service) method
        orderService.saveOrderByCart(orderRequest, authHeader);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    /**
     * get all Order flow
     */
    @GetMapping
    @ApiOperation("get all Order flow")
    public List<OmsOrder> gerAllOrder(){
        return orderService.getAllOrder();
    }

    /**
     * get order via orderId
     * @param orderId
     * @return
     */
    @GetMapping("/{orderId}")
    @ApiOperation("get order via orderId")
    public ResponseEntity<OmsOrderResponse> getOrderById(@PathVariable("orderId") Long orderId) {
        var response = orderService.getOrderById(orderId);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
