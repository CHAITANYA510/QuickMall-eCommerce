package com.quickmall.cartservice.model;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class PmsSkuResponse {

    private Long skuId;

    private String skuName;

    private Long spuId;

    private BigDecimal price;

    private Long saleCount;

    /**
     * the stock number of sku product
     * new skuStock = old skuStock - sales
     */
    private Integer skuStock;

}
