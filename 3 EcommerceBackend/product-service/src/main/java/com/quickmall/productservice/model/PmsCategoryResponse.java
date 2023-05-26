package com.quickmall.productservice.model;
// https://blog.csdn.net/lovoo/article/details/130528601

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PmsCategoryResponse {

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
