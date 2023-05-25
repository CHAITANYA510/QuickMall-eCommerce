package com.quickMall.springbootecobackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity

public class PmsAttribute implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PmsAttributeId;

    private Long attributeId;

    private Long categoryId;

    private String attributeName;

    /**
     * 0 - no search; 1 - need search
     */
    private Integer searchType;

    /**
     * 0 - single value; 1 - multiple value
     */
    private Integer valueType;

    private String icon;

    /**
     * value set that can be selected
     */
    private String valueSelect;

    /**
     * 0 - marketing attribute; 1 - basic attribute
     */
    private Integer attributeType;

    /**
     * 0 - forbidden; 1 - enable
     */
    private Integer enable;

    /**
     * 0 - do not display on the intro page; 1 - display
     */
    private Integer showDescription;

}
