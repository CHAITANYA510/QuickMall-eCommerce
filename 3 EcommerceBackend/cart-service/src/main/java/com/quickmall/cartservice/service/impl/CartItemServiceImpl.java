package com.quickmall.cartservice.service.impl;

import com.quickmall.cartservice.service.CartItemService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2

public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private StringRedisTemplate strRedisTemp;

}
