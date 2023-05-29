package com.quickmall.orderservice.repository;

import com.quickmall.orderservice.entity.OmsOrderOperateHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperateHistoryRepository extends JpaRepository<OmsOrderOperateHistory, Long> {
}
