package com.quickmall.paymentservice.service.impl;

import com.quickmall.paymentservice.entity.TransactionDetail;
import com.quickmall.paymentservice.model.PaymentRequest;
import com.quickmall.paymentservice.repository.PaymentRepository;
import com.quickmall.paymentservice.service.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;


    @Override
    public long doPayment(PaymentRequest paymentRequest) {
        log.info("Record transaction details: " + paymentRequest);

        TransactionDetail transactionDetail = TransactionDetail.builder()
                .orderId(paymentRequest.getOrderId())
                .orderSn(paymentRequest.getOrderSn())
                .payType(paymentRequest.getPayType())
                .referenceNumber(paymentRequest.getReferenceNumber())
                .paymentDate(Instant.now())
                .paymentStatus("SUCCESS!")
                .userId("user_id001")
                .orderName("order_name")
                .payAmount(paymentRequest.getPayAmount())
                .build();

        paymentRepository.save(transactionDetail);

        log.info("Payment-Service: order has been paid Success!!!");

        return transactionDetail.getId();
    }
}
