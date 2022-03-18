package com.ikbal.sportyshoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ikbal.sportyshoes.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query("SELECT p FROM Product p WHERE "
			+"CONCAT(p.id, p.name, p.brand, p.madein, p.price)"+" LIKE %?1%")
	public List<Product> findAll(String keyword);

}
