package com.authsys.SpringSecurity.service;

import com.authsys.SpringSecurity.model.LoginMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginMessageConsumer {
    @Autowired
    private CouponProcessor couponProcessor;

    @RabbitListener(queues = "loginQueue")
    public void handleLoginMessage(LoginMessage message) {
        System.out.println("Received login message for user: " + message.getUsername());

        // Send a coupon to the user.
        // Delegate the message to the Processor to send the coupon
        couponProcessor.processLoginAndSendCoupon(message);

    }


}
