package com.quickmall.productservice.model;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class PmsSkuAttributeValueResponse {

    private Long skuAttributeValueId;

    private Long skuId;

    private Long attributeId;

    private String attributeName;

    private String attributeValue;

}
