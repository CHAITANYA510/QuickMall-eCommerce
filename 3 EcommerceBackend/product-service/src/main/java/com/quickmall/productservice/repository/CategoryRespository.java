package com.quickmall.productservice.repository;

import com.quickmall.productservice.entity.PmsCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRespository extends JpaRepository<PmsCategory, Long> {
}
