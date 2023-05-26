package com.quickmall.productservice.repository;

import com.quickmall.productservice.entity.PmsSpu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpuRepository extends JpaRepository<PmsSpu, Long> {
}
