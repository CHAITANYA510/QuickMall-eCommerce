package com.quickmall.cartservice.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class CartDTO {

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
