package com.quickmall.productservice.entity;

import com.quickmall.productservice.constant.AttributeType;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder

public class PmsAttribute implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
