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
 * 客户对账单明细
 */
public class SmsStatementCustomerDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerStatementDetailsId;

    private Long customerStatementId;

    private LocalDateTime transactionDate;

    private String transactionType;

    private BigDecimal transactionAmount;

    private String notes;

}
