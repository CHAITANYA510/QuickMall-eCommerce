package com.quickmall.orderservice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.List;

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
