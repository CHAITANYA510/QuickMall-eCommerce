package com.quickmall.supplierservice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder
/**
 * 库存统计
 */
public class SmsSupplierStock {

    private static final long serialVersionUID = 1L;

    /**
     * supplierStockId及商品id，productId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierStockId;

    private Long supplierId;

    private String supplierStockName;

    private Long brandId;

    private Long categoryId;

    /**
     * 计量单位
     */
    private String unit;

    /**
     * 初始库存
     */
    private BigInteger beginningStock;

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

    /**
     * 出库数量
     */
    private BigInteger outboundQuantity;

    /**
     * 商品出库单价（销售）
     */
    private BigDecimal outboundUnitPrice;

    /**
     * 出库总金额
     */
    private BigDecimal outboundAmount;

    /**
     * 期末库存
     */
    private BigInteger quantityInStock;

    /**
     * 总金额
     */
    private BigDecimal totalPrice;

    /**
     * 安全库存
     */
    private BigInteger safeStock;

    /**
     * 库存报警
     */
    private boolean stockAlert;

    private LocalDateTime lastUpdateDate;

    private String skuDefaultImage;

    private String skuSubTitle;

    private String skuDescription;

}
