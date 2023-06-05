package com.quickmall.cartservice.model;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class CartResponse {

    private Long cartId;

    private CartItem cartItem;

    public static class CartItem {
        private Long skuId;
        private Integer count;
        private BigDecimal price;
        private String attributes;
        private boolean isChecked;
        private Integer stock;
    }

}
