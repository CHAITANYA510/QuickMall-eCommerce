package com.quickmall.productservice.repository;

import com.quickmall.productservice.entity.PmsSku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkuRepository extends JpaRepository<PmsSku, Long> {
}
