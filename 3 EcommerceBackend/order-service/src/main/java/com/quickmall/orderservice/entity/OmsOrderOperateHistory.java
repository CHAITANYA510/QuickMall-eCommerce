package com.quickmall.orderservice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder

public class OmsOrderOperateHistory {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
