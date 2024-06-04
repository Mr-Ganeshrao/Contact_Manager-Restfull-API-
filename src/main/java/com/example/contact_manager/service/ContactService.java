package com.example.contact_manager.service;

import java.util.List;

import com.example.contact_manager.entity.Contact;


public interface ContactService {
	
	public String upsert(Contact contact);
	public List<Contact> getAllContacts();
	public Contact getContact(int cid);
	public String deleteContact(int cid); 

}
