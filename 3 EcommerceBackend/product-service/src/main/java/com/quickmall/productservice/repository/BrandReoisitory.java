package com.quickmall.productservice.repository;

import com.quickmall.productservice.entity.PmsBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandReoisitory extends JpaRepository<PmsBrand, Long> {
}
