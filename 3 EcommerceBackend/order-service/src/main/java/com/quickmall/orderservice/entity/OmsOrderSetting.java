package com.quickmall.orderservice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder

public class OmsOrderSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderSettingId;

    private Integer paymentOvertime;

    private Integer confirmReceiveOvertime;

    private Integer afterSaleServiceOvertime;

    private Integer usersFeedbackOvertime;

}
