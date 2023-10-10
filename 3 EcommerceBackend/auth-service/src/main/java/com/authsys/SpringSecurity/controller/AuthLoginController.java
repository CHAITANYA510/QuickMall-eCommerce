package com.authsys.SpringSecurity.controller;

import com.authsys.SpringSecurity.common.constant.SecurityConstants;
import com.authsys.SpringSecurity.model.LoginMessage;
import com.authsys.SpringSecurity.model.LoginRequest;
import com.authsys.SpringSecurity.service.AuthService;
import com.authsys.SpringSecurity.service.LoginMessagePublisher;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@Log4j2

public class AuthLoginController {

    @Autowired
    private AuthService authService;

//    @Autowired
//    private RabbitTemplate rabbitTemplate;

    @Autowired
    private LoginMessagePublisher loginMessagePublisher;

    @PostMapping("/login")
    @ApiOperation("login")
    public ResponseEntity<Void> login(@RequestBody LoginRequest loginRequest) {
        String token = authService.createToken(loginRequest);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(SecurityConstants.TOKEN_HEADER, token);

        // Publish login message
        loginMessagePublisher.publishLoginMessage(loginRequest.getUserName());
        log.info("message published!!");

        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
    }

    @PostMapping("/logout")
    @ApiOperation("logout")
    public ResponseEntity<Void> logout() {
        authService.removeToken();
        log.info("Successfully Logout!");
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
