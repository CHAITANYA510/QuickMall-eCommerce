package com.quickmall.orderservice.model;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class OmsOrderItemRequest {

    private Long orderItemId;

    private Long orderId;

    private Long orderSn;

    private Long skuId;

    /**
     * amount of product
     */
    private BigDecimal skuQuantity;

    private BigDecimal skuPrice;

    private Long spuId;

    private Long categoryId;

//    private Long skuAttributeValueId;

    private String attributeValueList;

//    private BigDecimal skuPrice;

//    private Long skuCode;

}
