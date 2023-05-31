package com.quickmall.productservice.entity;

import javax.persistence.*;

import com.quickmall.productservice.constant.PublishStatus;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder

public class PmsSpu implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long spuId;

    private Long categoryId;

    private Long brandId;

    private String brandName;

    /**
     * product publish status: ON_SALE; OUT_OF_STOCK
     */
    private PublishStatus publishStatus;

    private String spuName;

    private String spuDescription;

    private Date createTime;

    private Date updateTime;

//    private String spuComment;
//
//    /**
//     * product approved status: APPROVED; DECLINED
//     */
//    private ApprovedStatus spuApprovedStatus;

}
