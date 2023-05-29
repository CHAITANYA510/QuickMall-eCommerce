package com.quickmall.orderservice.model;

import lombok.*;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class OmsOrderOperateHistoryRequest {

    private Long orderOperateHistoryId;

    private Long orderId;

    /**
     * operator: User, Admin, Tester, System
     */
    private String operator;

    private Instant operateTime;

    private Integer orderStatus;

    private String note;

}
