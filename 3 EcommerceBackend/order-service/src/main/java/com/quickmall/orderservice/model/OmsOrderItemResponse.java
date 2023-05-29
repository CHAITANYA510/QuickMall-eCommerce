package com.quickmall.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class OmsOrderItemResponse {

    private Long orderItemId;

    private Long orderId;

    private Long orderSn;

    private Long skuId;

    /**
     * amount of product
     */
    private BigDecimal skuQuantity;

    private Long spuId;

    private BigDecimal spuPrice;

    private Long categoryId;

//    private Long skuAttributeValueId;

    private String attributeValueList;

//    private BigDecimal skuPrice;

//    private Long skuCode;

}
