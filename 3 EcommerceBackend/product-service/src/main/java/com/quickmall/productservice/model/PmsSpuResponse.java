package com.quickmall.productservice.model;

import com.quickmall.productservice.constant.ApprovedStatus;
import com.quickmall.productservice.constant.PublishStatus;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PmsSpuResponse {

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
