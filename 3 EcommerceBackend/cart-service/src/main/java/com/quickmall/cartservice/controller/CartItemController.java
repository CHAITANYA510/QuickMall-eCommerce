package com.quickmall.cartservice.controller;

import com.quickmall.cartservice.constant.RedisConstant;
import com.quickmall.cartservice.entity.CartItem;
import com.quickmall.cartservice.model.CartItemResponse;
import com.quickmall.cartservice.service.CartItemService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/cart/v1/cartItems")
@Log4j2

public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody CartItemResponse cartItemResponse,
                               @RequestParam("cartId") Long cartId) {
        String cartKey = RedisConstant.CART_PREFIX + cartId;
        cartItemService.saveCartItem(cartItemResponse, cartKey);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CartItem>> getSelectedItems(@PathParam("cartId") Long cartId) {
        String cartKey = RedisConstant.CART_PREFIX + cartId;
        List<CartItem> selectedCartItems = cartItemService.getSelectedItems(cartKey);

        return new ResponseEntity<>(selectedCartItems, HttpStatus.OK);
    }


}
