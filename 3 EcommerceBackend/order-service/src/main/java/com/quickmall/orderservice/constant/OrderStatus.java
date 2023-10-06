package com.quickmall.orderservice.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {

    /**
     * order is preparing
     */
    PREPARING(0, "Preparing"),

    /**
     * order successful received by customer
     */
    DELIVERED(1, "Receive"),

    /**
     * order is delivering on the way
     */
    ON_THE_WAY(2, "OnTheWay"),

    /**
     * order is failed to be created
     */
    FAILED(3, "OrderFailedToBECreated");

    private final Integer value;
    private final String text;
}
