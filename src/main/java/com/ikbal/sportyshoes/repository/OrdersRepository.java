package com.ikbal.sportyshoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ikbal.sportyshoes.entity.Orders;


@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

	@Query("SELECT o FROM Orders o WHERE "
			+"CONCAT(o.id, o.name, o.category, o.orderedon)"+" LIKE %?1%")
	public List<Orders> findAll(String keyword);
}
