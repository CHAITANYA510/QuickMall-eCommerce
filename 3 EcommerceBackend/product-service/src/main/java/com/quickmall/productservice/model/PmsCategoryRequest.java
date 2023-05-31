package com.quickmall.productservice.model;
// https://blog.csdn.net/lovoo/article/details/130528601

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class PmsCategoryRequest {

    private Long categoryId;

    private String categoryName;

    private Long parentId;

    private Integer categoryLevel;

    private Integer sort;

}
