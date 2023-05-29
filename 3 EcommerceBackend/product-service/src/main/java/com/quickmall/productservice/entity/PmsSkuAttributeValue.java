package com.quickmall.productservice.entity;

import javax.persistence.*;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder

public class PmsSkuAttributeValue implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skuAttributeValueId;

    private Long skuId;

    private Long attributeId;

    private String attributeName;

    private String attributeValue;

//    private Integer attributeSort;

}
