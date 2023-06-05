package com.quickmall.cartservice.service;

import com.quickmall.cartservice.entity.CartItem;
import com.quickmall.cartservice.model.CartItemResponse;

import java.util.List;

public interface CartItemService {
    List<CartItem> getItemsByCartId(String cartKey);

    void saveCartItem(CartItemResponse cartItemResponse, String cartKey);

    List<CartItem> getSelectedItems(String cartKey);

    void deleteCartItem(Long skuId, String cartKey);

    void updateCartItem(CartItemResponse cartItemResponse, String cartKey);
}
