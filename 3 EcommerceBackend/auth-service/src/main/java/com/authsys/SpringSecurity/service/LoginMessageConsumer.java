package com.authsys.SpringSecurity.service;

import com.authsys.SpringSecurity.external.CouponFeignService;
import com.authsys.SpringSecurity.model.LoginMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class LoginMessageConsumer {
    @Autowired
    private CouponFeignService couponFeignService;

    @RabbitListener(queues = "loginQueue")
    public void handleLoginMessage(LoginMessage message) {
        log.info("Received login message for user: " + message.getUsername());

        // Send a coupon to the user.
        // Delegate the message to the Processor to send the coupon
        ResponseEntity<String> couponInfo = couponFeignService.sendCouponToUser(message);
        log.info(couponInfo.getBody());

    }


}
