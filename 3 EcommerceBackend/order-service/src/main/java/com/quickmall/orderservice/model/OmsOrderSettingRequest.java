package com.quickmall.orderservice.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class OmsOrderSettingRequest {

    private Long orderSettingId;

    private Integer paymentOvertime;

    private Integer confirmReceiveOvertime;

    private Integer afterSaleServiceOvertime;

    private Integer usersFeedbackOvertime;

}
