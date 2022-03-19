package com.ikbal.sportyshoes.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	
	    private Long id;
	    private String fname;
	    private String lname;
	    private String email;
	    private int phone;
	    private String address;
	 
	  
	 
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    public Long getId() {
	        return id;
	    }
	    
	    public Customer() {
	    }

		public Customer(Long id, String fname, String lname, String email, int phone, String address) {
			super();
			this.id = id;
			this.fname = fname;
			this.lname = lname;
			this.email = email;
			this.phone = phone;
			this.address = address;
		}

		public String getFname() {
			return fname;
		}

		public void setFname(String fname) {
			this.fname = fname;
		}

		public String getLname() {
			return lname;
		}

		public void setLname(String lname) {
			this.lname = lname;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public int getPhone() {
			return phone;
		}

		public void setPhone(int phone) {
			this.phone = phone;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public void setId(Long id) {
			this.id = id;
		}

		
	

}
