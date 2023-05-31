package com.quickmall.productservice.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class PmsBrandResponse {

    private Long brandId;

    private String brandName;

    private Integer sort;

}
