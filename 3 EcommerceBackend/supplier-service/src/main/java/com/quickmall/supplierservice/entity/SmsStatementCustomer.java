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
 * 客户对账单
 */
public class SmsStatementCustomer {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerStatementId;

    private Long customerId;

    private Long statementSn;

    private LocalDateTime statementDate;

    private String notes;

    private Long orderId;

    private Long orderSn;

}
