package com.quickmall.cartservice.controller;

import com.quickmall.cartservice.constant.RedisConstant;
import com.quickmall.cartservice.entity.CartItem;
import com.quickmall.cartservice.model.CartItemResponse;
import com.quickmall.cartservice.service.CartItemService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart/v1/cartItems")
@Log4j2

public class CartItemController {

    @Autowired
    private CartItemService cartItemService;
    
}
