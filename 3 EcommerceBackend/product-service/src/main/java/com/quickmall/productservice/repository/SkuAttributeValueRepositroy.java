package com.quickmall.productservice.repository;

import com.quickmall.productservice.entity.PmsSkuAttributeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkuAttributeValueRepositroy extends JpaRepository<PmsSkuAttributeValue, Long> {
}
