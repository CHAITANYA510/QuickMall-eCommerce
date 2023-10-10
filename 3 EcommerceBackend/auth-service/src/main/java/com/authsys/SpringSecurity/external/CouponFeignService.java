package com.authsys.SpringSecurity.external;

import com.authsys.SpringSecurity.model.LoginMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "COUPON-SERVICE/api/coupon/v1")
public interface CouponFeignService {

    @PostMapping("/coupons/loginmsg")
    public ResponseEntity<String> sendCouponToUser(@RequestBody LoginMessage message);
}
