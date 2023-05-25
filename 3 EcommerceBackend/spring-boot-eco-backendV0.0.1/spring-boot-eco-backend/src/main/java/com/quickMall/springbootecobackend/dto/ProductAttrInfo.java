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

public class ProductAttrInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ProductAttrInfoId;

    private Long attributeId;

    private Long attributeCategoryId;


}
