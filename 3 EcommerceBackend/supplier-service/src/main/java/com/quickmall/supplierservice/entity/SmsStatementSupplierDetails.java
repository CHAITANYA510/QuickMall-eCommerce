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
 * 供应商对账单明细
 */
public class SmsStatementSupplierDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierStatementDetailsId;

    private Long supplierStatementId;

    private LocalDateTime transactionDate;

    private String transactionType;

    private BigDecimal transactionAmount;

    private String notes;

}
