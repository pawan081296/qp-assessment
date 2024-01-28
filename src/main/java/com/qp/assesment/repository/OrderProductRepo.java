package com.qp.assesment.repository;

import com.qp.assesment.entity.OrderProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepo extends JpaRepository<OrderProductEntity, Long> {
}
