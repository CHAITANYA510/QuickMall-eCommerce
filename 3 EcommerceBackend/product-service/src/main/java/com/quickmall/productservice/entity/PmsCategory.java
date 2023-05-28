package com.quickmall.productservice.entity;
// https://blog.csdn.net/lovoo/article/details/130528601

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder

public class PmsCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String categoryName;

    private Long parentId;

    private Integer categoryLevel;

    private Integer showStatus;

    private Integer sort;

    private String icon;

    private String productUnit;

    private Integer productCount;

//    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
//    @ElementCollection
//    private List<PmsCategory> children;

}
