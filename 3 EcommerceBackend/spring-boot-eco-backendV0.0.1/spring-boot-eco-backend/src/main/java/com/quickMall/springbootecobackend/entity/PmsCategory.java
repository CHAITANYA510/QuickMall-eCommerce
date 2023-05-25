package com.quickMall.springbootecobackend.entity;
// https://blog.csdn.net/lovoo/article/details/130528601

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class PmsCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PmsCategoryId;

//    @Column(unique = true)
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
