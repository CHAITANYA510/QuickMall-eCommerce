package com.quickmall.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class PmsCategoryBrandRelationRequest {

    private Long categoryBrandRelationId;

    private Long brandId;

    private Long categoryId;

    private String brandName;

    private String categoryName;

}
