package com.quickmall.productservice.repository;

import com.quickmall.productservice.entity.PmsAttributeGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttriGroupRepository extends JpaRepository<PmsAttributeGroup, Long> {
}
