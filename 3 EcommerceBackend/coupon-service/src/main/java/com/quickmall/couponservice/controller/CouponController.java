package com.quickmall.couponservice.controller;

import com.quickmall.couponservice.entity.Coupon;
import com.quickmall.couponservice.model.LoginMessage;
import com.quickmall.couponservice.service.CouponProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coupon/v1/coupons")
public class CouponController {

    @Autowired
    private CouponProcessor couponProcessor;

    @PostMapping("/loginmsg")
    public ResponseEntity<String> sendCouponToUser(@RequestBody LoginMessage loginMessage) {
        Coupon coupon = couponProcessor.processLoginAndSendCoupon(loginMessage);
        return ResponseEntity.ok("Coupon sent to user: " + loginMessage.getUsername() + ", coupon: " + coupon);
    }

}
