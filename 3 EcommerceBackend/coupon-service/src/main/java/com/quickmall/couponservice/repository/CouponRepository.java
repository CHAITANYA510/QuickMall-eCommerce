package com.quickmall.couponservice.repository;

import com.quickmall.couponservice.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    Coupon findFirstByIsActive(boolean b);
}
