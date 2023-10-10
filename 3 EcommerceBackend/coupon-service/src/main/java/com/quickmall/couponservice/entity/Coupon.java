package com.quickmall.couponservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "coupon")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "coupon_code", nullable = false, unique = true)
    private String couponCode;

    @Column(name = "description")
    private String description;

    @Column(name = "discount_amount")
    private BigDecimal discountAmount;

    @Column(name = "is_active", nullable = true)
    private Boolean isActive;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

}
