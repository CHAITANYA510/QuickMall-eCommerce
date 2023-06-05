package com.quickmall.cartservice.service;

import com.quickmall.cartservice.entity.CartItem;
import com.quickmall.cartservice.model.CartItemResponse;

import java.util.List;

public interface CartItemService {
    List<CartItem> getItemsByCartId(String cartKey);
}
