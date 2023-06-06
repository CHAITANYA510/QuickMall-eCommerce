package com.quickmall.cartservice.controller;

import com.quickmall.cartservice.constant.RedisConstant;
import com.quickmall.cartservice.entity.CartItem;
import com.quickmall.cartservice.model.CartItemResponse;
import com.quickmall.cartservice.service.CartItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api("CartItem Info")

public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    /**
     * save the cartItems
     * @param cartItemResponse
     * @param cartId
     * @return
     */
    @PostMapping
    @ApiOperation("save the cartItems")
    public ResponseEntity<Void> save(@RequestBody CartItemResponse cartItemResponse,
                               @RequestParam("cartId") Long cartId) {
        String cartKey = RedisConstant.CART_PREFIX + cartId;
        cartItemService.saveCartItem(cartItemResponse, cartKey);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    /**
     * get the selected CartItems
     * @param cartId
     * @return
     */
    @GetMapping("/{cartId}")
    @ApiOperation("get the selected CartItems")
    public ResponseEntity<List<CartItem>> getSelectedItems(@PathVariable("cartId") Long cartId) {
        String cartKey = RedisConstant.CART_PREFIX + cartId;
        List<CartItem> selectedCartItems = cartItemService.getSelectedItems(cartKey);

        return new ResponseEntity<>(selectedCartItems, HttpStatus.OK);
    }

    /**
     * Delete the Cart Item by skuIdd
     * @param skuId
     * @param cartId
     */
    @DeleteMapping("/sku/{skuId}")
    @ApiOperation("Delete the Cart Item by skuIdd")
    public void deleteCartItem(@PathVariable("skuId") Long skuId, @RequestParam("id") Long cartId) {
        String cartKey = RedisConstant.CART_PREFIX + cartId;
        cartItemService.deleteCartItem(skuId, cartKey);
    }

    /**
     * update the Cart Item's status: isChecked(checked) status & count
     * @param cartItemResponse
     * @param cartId
     */
    @PutMapping
    @ApiOperation("update the Cart Item's status: checked & count")
    public void updateCartItem(@RequestBody CartItemResponse cartItemResponse, @RequestParam("cartId") Long cartId) {
        String cartKey = RedisConstant.CART_PREFIX + cartId;
        cartItemService.updateCartItem(cartItemResponse, cartKey);
    }

}
