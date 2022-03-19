package com.ikbal.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ikbal.sportyshoes.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {


}
