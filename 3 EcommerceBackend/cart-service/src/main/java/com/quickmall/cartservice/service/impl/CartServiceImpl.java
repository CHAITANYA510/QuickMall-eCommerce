package com.quickmall.cartservice.service.impl;

import com.quickmall.cartservice.service.CartItemService;
import com.quickmall.cartservice.service.CartService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2

public class CartServiceImpl implements CartService {

    @Autowired
    private CartItemService cartItemService;

}
