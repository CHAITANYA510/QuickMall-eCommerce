package com.quickmall.cartservice.service;

import com.quickmall.cartservice.entity.CartItem;

import java.util.List;

public interface CartService {
    List<CartItem> getItemsByCartId(String cartKey);
}
