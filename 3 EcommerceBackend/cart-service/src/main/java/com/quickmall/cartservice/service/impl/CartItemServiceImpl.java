package com.quickmall.cartservice.service.impl;

import com.alibaba.fastjson.JSON;

import com.quickmall.cartservice.entity.CartItem;
import com.quickmall.cartservice.model.CartItemResponse;
import com.quickmall.cartservice.service.CartItemService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2

public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private StringRedisTemplate strRedisTemp;

    /**
     * list all the items in a Cart
     * @param cartKey
     * @return
     */
    @Override
    public List<CartItem> getItemsByCartId(String cartKey) {
        List<CartItem> cartItemList = strRedisTemp.boundHashOps(cartKey).values()
                .stream()
                .map(String::valueOf)
                .map(json -> JSON.parseObject(json, CartItem.class))
                .collect(Collectors.toList());

        log.info("cartItemList:" + cartItemList);

        return cartItemList;
    }
}
