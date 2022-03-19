package com.ikbal.sportyshoes.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ikbal.sportyshoes.entity.Customer;
import com.ikbal.sportyshoes.entity.Orders;
import com.ikbal.sportyshoes.entity.Product;
import com.ikbal.sportyshoes.repository.CustomerRepository;
import com.ikbal.sportyshoes.repository.OrdersRepository;
import com.ikbal.sportyshoes.repository.ProductRepository;

@Service
@Transactional
public class OrdersService {
	
	
	    @Autowired
	    private OrdersRepository orderRepo;
	     
	    public List<Orders> listAll() {
	    	return orderRepo.findAll();
	    }
	     
	    public void save(Orders orders) {
	    	orderRepo.save(orders);
	    }
	     


}
