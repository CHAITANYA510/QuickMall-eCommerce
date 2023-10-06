package com.quickmall.paymentservice.model;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PaymentRequest {

    private Long orderId;

    private Long orderSn;

    private BigDecimal payAmount;

    private String referenceNumber;

    private PayType payType;

}
