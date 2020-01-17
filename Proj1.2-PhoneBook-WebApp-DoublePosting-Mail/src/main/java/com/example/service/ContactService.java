package com.example.service;

import java.util.List;

import com.example.domain.Contact;

public interface ContactService {

	public boolean saveContact(Contact c);

	public List<Contact> getAllContacts();

	public Contact getContactById(Integer cid);
    
	boolean updateContact(Contact c);

	public boolean deleteContactById(Integer cid);
	
	public void sendEmailByMail(String to);

	
}
