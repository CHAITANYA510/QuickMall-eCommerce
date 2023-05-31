package com.quickmall.orderservice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder

public class OmsOrderItem {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

}
