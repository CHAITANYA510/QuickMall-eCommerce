package com.quickmall.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class OmsOrderOperateHistoryResponse {

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
