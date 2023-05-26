package com.quickmall.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class PmsSkuResponse {

    private Long skuId;

    private Long spuId;

    private Long categoryId;

    private Long brandId;

    private String skuName;

    private String skuDescription;

    private String skuDefaultImage;

    private String skuTitle;

    private String skuSubTitle;

    private BigDecimal price;

    private Long saleCount;

}
