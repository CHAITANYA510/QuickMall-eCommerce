package com.quickmall.productservice.repository;

import com.quickmall.productservice.entity.PmsAttriGroupRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttriGroupRelationRepository extends JpaRepository<PmsAttriGroupRelation, Long> {
}
