package com.authsys.SpringSecurity.service;

import com.authsys.SpringSecurity.model.LoginMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginMessagePublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void publishLoginMessage(String username) {
        LoginMessage message = new LoginMessage(username);
        rabbitTemplate.convertAndSend("loginQueue", message);
    }

}
