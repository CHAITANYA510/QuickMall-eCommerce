package com.quickmall.orderservice.external.client;

import com.quickmall.orderservice.model.PaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PAYMENT-SERVICE/api/payment/v1")
public interface PaymentFeginService {                  // interface!!

    @PostMapping("/creditcard")
    public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest);
}
