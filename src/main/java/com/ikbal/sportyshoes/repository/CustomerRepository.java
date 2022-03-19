package com.ikbal.sportyshoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ikbal.sportyshoes.entity.Customer;
import com.ikbal.sportyshoes.entity.Product;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	@Query("SELECT c FROM Customer c WHERE "
			+"CONCAT(c.fname, c.lname, c.email, c.phone, c.address)"+" LIKE %?1%")
	public List<Customer> findAll(String keyword);

}
