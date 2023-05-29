package com.quickmall.orderservice.entity;

import com.quickmall.orderservice.constant.OrderStatus;
import com.quickmall.orderservice.constant.PayType;
import com.quickmall.orderservice.constant.ReceiptType;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder

public class OmsOrder {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Long orderSn;

    private BigDecimal totalAmount;

    private BigDecimal payAmount;

    /**
     * payment method
     */
    private PayType payType;

    /**
     * order status: Preparing/ On_the_Way/ Receive
     */
    private OrderStatus orderStatus;


    /**
     * receipt type: no receipt/ text receipt/ emaill receipt
     */
    private ReceiptType receiptType;

    /**
     * order's extra info; order's notes
     */
    private String note;

    private Date orderCreateTime;

    private Date paymentTime;

    private Date confirmTime;

    /**
     * if order is confirmed: 1 - confirm; 0 - not confirm;
     */
    private Integer isConfirm;

    /**
     * after 10 days on the way status; the order will be received without user's check
     */
//    private Instant autoConfirmTime;

    /**
     * order delivered time
     */
    private Date deliveredTime;


//    private Integer sourceType;

}
