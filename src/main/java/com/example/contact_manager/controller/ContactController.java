package com.example.contact_manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.contact_manager.entity.Contact;
import com.example.contact_manager.service.ContactServiceImpl;

@RestController
public class ContactController {
	
	@Autowired
	private ContactServiceImpl service;
	
	//user inserting data
	@PostMapping("/contact")
	public ResponseEntity<String> contact(@RequestBody Contact contact){
		String status =service.upsert(contact);
		return new ResponseEntity<>(status, HttpStatus.CREATED);
		
	}
	
	// user retrive all comtact
	@GetMapping("/contacts")
	public ResponseEntity<List<Contact>> getAllContacts(){
		List<Contact> allContacts=service.getAllContacts();
		return new ResponseEntity<>(allContacts,HttpStatus.OK);
		    
	}  
	
	//user get contact according to id
	@GetMapping("/contact/{cid}")
	public ResponseEntity<Contact> getContact(@PathVariable int cid){
	Contact contact=service.getContact(cid);
	return new ResponseEntity<>(contact,HttpStatus.OK);
	}
	
	//user delete record according to id
	@DeleteMapping("/contact/{cid}")
	public ResponseEntity<String> deleteContact(@PathVariable int cid){
		String deleteContact=service.deleteContact(cid);
		return new ResponseEntity<>(deleteContact, HttpStatus.OK);
	}

}
