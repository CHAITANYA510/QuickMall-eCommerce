package com.quickmall.productservice.entity;

import javax.persistence.*;

import com.quickmall.productservice.constant.ApprovedStatus;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

// https://blog.csdn.net/lxw1844912514/article/details/100028595  update sku datatable
// https://blog.csdn.net/lovoo/article/details/130528601 design refer

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder

public class PmsSku implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    /**
     * the stock number of sku product
     * new skuStock = old skuStock - sales
     */
    private Integer skuStock;

    private Date createTime;

    /**
     * sku approved status: APPROVED; DECLINED
     */
    private ApprovedStatus skuApproveStatus;

}
