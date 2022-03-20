package com.ikbal.sportyshoes.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Orders implements Serializable{
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
	    private String name;
	   
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date orderedon;
	
	    
	    public Orders() {
	    }


		public Orders(Long id, String name, Date orderedon) {
			super();
			this.id = id;
			this.name = name;
			this.orderedon = orderedon;
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public Date getOrderedon() {
			return orderedon;
		}


		public void setOrderedon(Date orderedon) {
			this.orderedon = orderedon;
		}




	    

}
