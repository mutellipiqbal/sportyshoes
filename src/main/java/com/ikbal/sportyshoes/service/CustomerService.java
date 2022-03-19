package com.ikbal.sportyshoes.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ikbal.sportyshoes.entity.Customer;
import com.ikbal.sportyshoes.entity.Product;
import com.ikbal.sportyshoes.repository.CustomerRepository;
import com.ikbal.sportyshoes.repository.ProductRepository;

@Service
@Transactional
public class CustomerService {
	
	
	    @Autowired
	    private CustomerRepository cusRepo;
	     
	    public List<Customer> listAll(String keyword) {
	    	if(keyword !=null) {
	    		return cusRepo.findAll(keyword);
	    	}
	        return cusRepo.findAll();
	    }
	     
	    public void save(Customer customer) {
	    	cusRepo.save(customer);
	    }
	     
	    public Customer get(long id) {
	        return cusRepo.findById(id).get();
	    }
	     
	    public void delete(long id) {
	    	cusRepo.deleteById(id);
	    }

}
