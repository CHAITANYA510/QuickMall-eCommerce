package com.quickmall.orderservice.repository;

import com.quickmall.orderservice.entity.OmsOrderSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderSettingRepostory extends JpaRepository<OmsOrderSetting, Long> {
}
