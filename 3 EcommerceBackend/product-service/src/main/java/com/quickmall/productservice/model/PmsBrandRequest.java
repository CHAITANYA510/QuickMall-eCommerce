package com.quickmall.productservice.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class PmsBrandRequest {

    private Long brandId;

    private String brandName;

    private Integer sort;

}
