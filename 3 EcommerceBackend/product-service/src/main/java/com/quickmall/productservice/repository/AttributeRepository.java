package com.quickmall.productservice.repository;

import com.quickmall.productservice.entity.PmsAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeRepository extends JpaRepository<PmsAttribute, Long> {
}
