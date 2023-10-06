package com.quickmall.paymentservice.repository;

import com.quickmall.paymentservice.entity.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<TransactionDetail, Long> {
}
