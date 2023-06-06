package com.quickmall.orderservice.model;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class CartItem implements Serializable {

    private static final long serializationId = 1L;

    private Long skuId;

    private Integer count;

    private BigDecimal price;

    private String attributes;

    private boolean isChecked;

    private Integer skuStock;

    private BigDecimal totalPrice;

}
