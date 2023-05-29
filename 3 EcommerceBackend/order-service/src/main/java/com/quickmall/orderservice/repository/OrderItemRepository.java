package com.quickmall.orderservice.repository;

import com.quickmall.orderservice.entity.OmsOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OmsOrderItem, Long> {
}
