package com.quickMall.springbootecobackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity

public class PmsSPUinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PmsSPUinfoId;

//    @Column(unique = true)
    private Long spuId;

    private Long categoryId;

    private Long brandId;

    private String spuName;

    private String spuDescription;

    private String brandName;

    private BigDecimal weight;

    private Integer publishStatus;

    private Date createTime;

    private Date updateTime;

}
