package com.quickmall.orderservice.model;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class OmsOrderItemResponse {

    private Long orderItemId;

    private Long orderId;

    private Long orderSn;

    private Long categoryId;

    private Long spuId;

    private  String spuName;

    private String spuBrand;

    private Long skuId;

    private BigDecimal skuPrice;

    /**
     * amount of product
     */
    private BigDecimal skuQuantity;

    private String attributeValueList;

    private Integer count;

}
