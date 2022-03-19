package com.ikbal.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ikbal.sportyshoes.entity.Customer;
import com.ikbal.sportyshoes.entity.Product;
import com.ikbal.sportyshoes.service.CustomerService;
import com.ikbal.sportyshoes.service.ProductService;

@Controller
public class AppController {
	@Autowired
    private ProductService service;
	
	@Autowired
	private CustomerService cusService;
	
	@GetMapping("product")
	public String viewProductPage(Model model, @Param("keyword") String keyword) {
	    List<Product> listProducts = service.listAll(keyword);
	    model.addAttribute("listProducts", listProducts);
	     
	    return "product";
	}
	
	@RequestMapping("product/new")
	public String showNewProductPage(Model model) {
	    Product product = new Product();
	    model.addAttribute("product", product);
	     
	    return "new_product";
	}
	
	@PostMapping("/save")
	public String saveProduct(@ModelAttribute("product") Product product) {
	    service.save(product);
	     
	    return "redirect:/product";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("edit_product");
	    Product product = service.get(id);
	    mav.addObject("product", product);
	     
	    return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
	    service.delete(id);
	    return "redirect:/product";       
	}
	
	//customer
	
	@GetMapping("customer")
	public String viewCustomerPage(Model model, @Param("keyword") String keyword) {
	    List<Customer> listCustomers = cusService.listAll(keyword);
	    model.addAttribute("listCustomers", listCustomers);
	     
	    return "customer";
	}
	
	@RequestMapping("customer/new")
	public String showNewCustomerPage(Model model) {
	    Customer customer= new Customer();
	    model.addAttribute("customer", customer);
	     
	    return "customer_signup";
	}
	
	@PostMapping("/cussave")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		cusService.save(customer);
	     
	    return "redirect:/customer";
	}

}
