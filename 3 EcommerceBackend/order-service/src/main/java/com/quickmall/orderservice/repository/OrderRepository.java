package com.quickmall.orderservice.repository;

import com.quickmall.orderservice.entity.OmsOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OmsOrder, Long> {
}
