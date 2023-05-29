package com.quickmall.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class OmsOrderSettingResponse {

    private Long orderSettingId;

    private Integer paymentOvertime;

    private Integer confirmReceiveOvertime;

    private Integer afterSaleServiceOvertime;

    private Integer usersFeedbackOvertime;

}
