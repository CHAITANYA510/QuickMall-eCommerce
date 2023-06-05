package com.quickmall.cartservice.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class CartItemDTO {

    private Long skuId;

    private Integer count;

    private BigDecimal price;

    private String attributes;

    private boolean isChecked;

    private Integer skuStock;

}
