package com.example.contact_manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.contact_manager.entity.Contact;
import com.example.contact_manager.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository repo;
	
	@Override
	public String upsert(Contact contact) {
		Contact save=repo.save(contact);
		if(save!=null) {
		return "Contact Inserted Successfully !!!";}
		else {
			return "Something Went wrong!!!!!";
		}
	}

	@Override
	public List<Contact> getAllContacts() {
		
		return repo.findAll();
	}

	@Override
	public Contact getContact(int cid) {
		
	Optional<Contact> findById=repo.findById(cid);
		
	if(findById.isPresent()) {
		return  findById.get();}
	else {
		return null;
	}
	}

	@Override
	public String deleteContact(int cid) {
		repo.deleteById(cid);
		return "Record Deleted Success";
	}

}
