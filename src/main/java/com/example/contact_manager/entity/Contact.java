package com.example.contact_manager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "CONTACT_DETAILS")
@Data  
public class Contact {

	@Id 
	@GeneratedValue  
	private int id;
	private String name;
	private String email;
	private long phno;
	private String activeSw;
}
