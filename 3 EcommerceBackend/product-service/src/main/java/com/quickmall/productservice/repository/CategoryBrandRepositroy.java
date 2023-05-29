package com.quickmall.productservice.repository;

import com.quickmall.productservice.entity.PmsCategoryBrandRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryBrandRepositroy extends JpaRepository<PmsCategoryBrandRelation, Long> {
}
