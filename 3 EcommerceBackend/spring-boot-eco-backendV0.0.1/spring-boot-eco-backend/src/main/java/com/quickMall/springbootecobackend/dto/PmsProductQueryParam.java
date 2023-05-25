package com.quickMall.springbootecobackend.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class PmsProductQueryParam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer publishStatus;
    private Integer verifyStatus;
    private String keyword;
    // product number
    private String productSn;
    // product categoryId
    private Long productCategoryId;
    private Long brandId;

}
