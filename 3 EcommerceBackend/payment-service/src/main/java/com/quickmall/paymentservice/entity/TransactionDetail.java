package com.quickmall.paymentservice.entity;

import com.quickmall.paymentservice.model.PayType;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder
public class TransactionDetail {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Order id
     */
    private Long orderId;

    /**
     * orderSn
     */
    private Long orderSn;

    private PayType payType;

    private String referenceNumber;

    private Instant paymentDate;

    private String paymentStatus;

    /**
     * User Id
     */
    private String userId;

    /**
     * Order Name
     */
    private String orderName;

    /**
     * payment amount
     */
    private BigDecimal payAmount;

}
