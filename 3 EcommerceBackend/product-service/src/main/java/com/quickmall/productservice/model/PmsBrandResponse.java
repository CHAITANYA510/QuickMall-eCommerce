package com.quickmall.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class PmsBrandResponse {

    private Long brandId;

    private String brandName;

    private String logo;

    private String description;

    private Integer showStatus;

    private String firstLetter;

    private Integer sort;

}
