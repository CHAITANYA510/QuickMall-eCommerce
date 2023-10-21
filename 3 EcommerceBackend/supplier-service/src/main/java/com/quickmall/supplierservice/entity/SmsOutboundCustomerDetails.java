package com.quickmall.supplierservice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder
/**
 * 出库明细（销售单明细）客户
 */
public class SmsOutboundCustomerDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerOutboundDetailsId;

    private Long customerOutboundId;

    private Long supplierStockId;

    private Long brandId;

    private Long categoryId;

    /**
     * 计量单位
     */
    private String unit;

    /**
     * 出库数量
     */
    private BigInteger inboundQuantity;

    /**
     * 出库单价（销售）
     */
    private BigDecimal inboundUnitPrice;

    /**
     * 出库总金额
     */
    private BigDecimal inboundAmount;

    private String skuDefaultImage;

    private String skuSubTitle;

    private String skuDescription;

}
