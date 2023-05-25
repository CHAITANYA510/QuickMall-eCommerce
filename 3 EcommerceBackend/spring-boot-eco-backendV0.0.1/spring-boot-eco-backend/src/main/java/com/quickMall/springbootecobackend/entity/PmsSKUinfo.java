package com.quickMall.springbootecobackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.UniqueElements;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity

public class PmsSKUinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PmsSKUinfoId;

//    @Column(unique = true)
    private Long skuId;

    private Long spuId;

    private Long categoryId;

    private Long brandId;

    private String skuName;

    private String skuDescription;

    private String skuDefaultImage;

    private String skuTitle;

    private String skuSubTitle;

    private BigDecimal price;

    private Long saleCount;

}
