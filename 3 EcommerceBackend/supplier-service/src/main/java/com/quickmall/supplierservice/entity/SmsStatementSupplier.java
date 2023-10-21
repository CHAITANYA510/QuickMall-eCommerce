package com.quickmall.supplierservice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder
/**
 * 供应商对账单
 */
public class SmsStatementSupplier {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierStatementId;

    private Long supplierId;

    private Long statementSn;

    private LocalDateTime statementDate;

    private BigDecimal openingBalance;

    private BigDecimal closingBalance;

    private String notes;

    private Long orderId;

    private Long orderSn;

}
