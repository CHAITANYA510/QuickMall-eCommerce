package com.quickmall.productservice.model;

import com.quickmall.productservice.constant.AttributeType;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class PmsAttributeResponse {

    private Long attributeId;

    private String attributeName;

    /**
     * MARKETING_ATTRIBUTE - Emarketing attribute; BASIC_ATTRIBUT - basic attribute
     */
    private AttributeType attributeType;

    /**
     * value set that can be selected
     */
    private String valueSelect;

    private Long categoryId;

}
