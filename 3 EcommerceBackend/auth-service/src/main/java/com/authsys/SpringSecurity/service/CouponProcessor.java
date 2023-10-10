package com.authsys.SpringSecurity.service;

import com.authsys.SpringSecurity.entity.Coupon;
import com.authsys.SpringSecurity.model.LoginMessage;
import com.authsys.SpringSecurity.repository.CouponRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CouponProcessor {

    @Autowired
    private CouponRepository couponRepository;

    @RabbitListener(queues = "loginQueue")
    public void processLoginAndSendCoupon(LoginMessage message) {
        Coupon coupon = couponRepository.findFirstByIsActive(true);
        if(coupon != null) {
            // send this coupon to the user
            sendCouponToUser(message.getUsername(), coupon);
        }
    }

    private void sendCouponToUser(String username, Coupon coupon) {
        // Logic to send the coupon to the user (e.g., by email, SMS, etc.)
        log.info("Received login message for user!!");
        log.info("Sending coupon to user " + username);
        log.info("Coupon Code: " + coupon.getCouponCode());
        log.info("Description: " + coupon.getDescription());
        log.info("Discount Amount: " + coupon.getDiscountAmount());

    }

}
