package com.quickmall.productservice.model;

import com.quickmall.productservice.constant.ApprovedStatus;
import com.quickmall.productservice.constant.PublishStatus;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class PmsSpuRequest {

    private Long spuId;

    private Long categoryId;

    private Long brandId;

    private String spuName;

    private String spuDescription;

    private String brandName;

    private BigDecimal weight;

    private Date createTime;

    private Date updateTime;

    /**
     * product approved status: APPROVED; DECLINED
     */
    private ApprovedStatus spuApprovedStatus;

    /**
     * product publish status: ON_SALE; OUT_OF_STOCK
     */
    private PublishStatus publishStatus;

    private BigDecimal price;

}
