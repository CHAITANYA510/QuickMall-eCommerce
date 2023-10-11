package com.quickmall.supplierservice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder

public class SmsSupplierProduct {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierProductId;

    private Long supplierId;

    private Long skuId;

    private Date supplyDate;

    private BigDecimal supplyPrice;

    private Long quantity;

    private BigDecimal finalPrice;

}
