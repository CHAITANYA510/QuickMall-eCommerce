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
 * 入库单明细（供应商）
 */
public class SmsInboundSupplierDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierInboundDetailsId;

    private Long supplierInboundId;

    private Long supplierStockId;

    private Long brandId;

    private Long categoryId;

    /**
     * 计量单位
     */
    private String unit;

    /**
     * 入库数量
     */
    private BigInteger inboundQuantity;

    /**
     * 入库单价（成本）
     */
    private BigDecimal inboundUnitPrice;

    /**
     * 入库总金额
     */
    private BigDecimal inboundAmount;

    private String skuDefaultImage;

    private String skuSubTitle;

    private String skuDescription;

}
