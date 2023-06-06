package com.quickmall.orderservice.external.client;

import com.quickmall.orderservice.model.CartItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.server.PathParam;
import java.util.List;

@FeignClient("CART-SERVICE/api/cart/v1")
public interface CartFeignService {

    /**
     * get the selected CartItems
     * @param cartId
     * @return
     */
    @GetMapping("/cartItems/{cartId}")
    public ResponseEntity<List<CartItem>> getSelectedItems(@PathVariable("cartId") Long cartId);

}
