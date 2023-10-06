package com.quickmall.paymentservice.service;

import com.quickmall.paymentservice.model.PaymentRequest;

public interface PaymentService {
    long doPayment(PaymentRequest paymentRequest);
}
