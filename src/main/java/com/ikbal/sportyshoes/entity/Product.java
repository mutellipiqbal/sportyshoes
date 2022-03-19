package com.ikbal.sportyshoes.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	
	    private Long id;
	    private String name;
	    private String brand;
	    private String madein;
	    private float price;
	    private int quantity;
	 
	  
	 
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    public Long getId() {
	        return id;
	    }
	    
	    public Product() {
	    }
	    
	    @ManyToMany(mappedBy = "customer")
	    Set<Customer> customers;

		public Product(Long id, String name, String brand, String madein, float price, int quantity) {
			super();
			this.id=id;
			this.name = name;
			this.brand = brand;
			this.madein = madein;
			this.price = price;
			this.quantity=quantity;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public String getMadein() {
			return madein;
		}

		public void setMadein(String madein) {
			this.madein = madein;
		}

		public float getPrice() {
			return price;
		}

		public void setPrice(float price) {
			this.price = price;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
	    
	    
	    
	    

		
	    

}
