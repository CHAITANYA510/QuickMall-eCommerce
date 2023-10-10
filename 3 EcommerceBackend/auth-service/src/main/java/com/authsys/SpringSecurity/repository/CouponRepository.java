package com.authsys.SpringSecurity.repository;

import com.authsys.SpringSecurity.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    Coupon findFirstByIsActive(boolean b);
}
