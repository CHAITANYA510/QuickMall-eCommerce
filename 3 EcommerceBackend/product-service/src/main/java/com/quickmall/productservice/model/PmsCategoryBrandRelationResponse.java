package com.quickmall.productservice.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class PmsCategoryBrandRelationResponse {

    private Long categoryBrandRelationId;

    private Long brandId;

    private Long categoryId;

    private String brandName;

    private String categoryName;

}
