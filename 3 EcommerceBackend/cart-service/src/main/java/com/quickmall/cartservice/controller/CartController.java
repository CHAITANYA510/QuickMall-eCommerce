package com.quickmall.cartservice.controller;

import com.quickmall.cartservice.service.CartService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart/v1/carts")
@Log4j2

public class CartController {

    @Autowired
    private CartService cartService;


}
