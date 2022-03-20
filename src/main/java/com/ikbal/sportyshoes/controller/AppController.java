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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ikbal.sportyshoes.entity.Admin;
import com.ikbal.sportyshoes.entity.Customer;


import com.ikbal.sportyshoes.entity.Orders;
import com.ikbal.sportyshoes.entity.Product;
import com.ikbal.sportyshoes.service.CustomerService;

import com.ikbal.sportyshoes.service.OrdersService;
import com.ikbal.sportyshoes.service.ProductService;

@Controller
public class AppController {
	@Autowired
    private ProductService service;
	
	@Autowired
	private CustomerService cusService;
	
	@Autowired
	private OrdersService oService;
	
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
	     
	    return "customer_register";
	}
	
	@PostMapping("/cussave")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		cusService.save(customer);
	     
	    return "redirect:/";
	}
	
	
	@RequestMapping("/login")
	public String display() {
		return "login";
	}
	
	@RequestMapping("dasboard")
	public String dashBoard() {
		return "dasboard";
	}
	
	@GetMapping("orders/new")
    public String main(Model model) {
        model.addAttribute("orders", new Orders());
        return "new_orders";
    }
	
	@PostMapping("/osave")
	public String saveStudent(@ModelAttribute("orders") Orders orders) {
		oService.save(orders);
	    return "redirect:/orders";
	}

	
	@GetMapping("orders")
	public String viewOrderPage(Model model, @Param("keyword") String keyword) {
	    List<Orders> ordersList=oService.listAll(keyword);
	    model.addAttribute("ordersList", ordersList);
   
	    return "orders";
	}
	


	@RequestMapping("logout")
	public String logout() {
		return "index";
	}
	
	



}
