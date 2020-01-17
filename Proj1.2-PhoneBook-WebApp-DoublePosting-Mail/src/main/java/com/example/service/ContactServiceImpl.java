package com.example.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Contact;
import com.example.entity.ContactDetailEntity;
import com.example.mail.EmailUtils;
import com.example.repository.ContactDetailRepository;

/**
 * 
 * @author Ashish
 * @version 1.0
 * @since 22.12.2019
 * 
 */

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactDetailRepository contactDetailsRepository;
	
	@Autowired
	private EmailUtils emailUtils;

	/**
	 * Save Contact Number
	 */
	@Override
	public boolean saveContact(Contact c) {
		boolean flag=false;
		ContactDetailEntity entity = new ContactDetailEntity();
		c.setActiveSw("Y");
		BeanUtils.copyProperties(c, entity);
		ContactDetailEntity saveEntity = contactDetailsRepository.save(entity);
		if(saveEntity.getContactId() > 0)
		    	sendEmailByMail("ashishkumarsingh336@gmail.com");
		return saveEntity.getContactId() > 0;
	}

	/**
	 * Get all Contact Number
	 */
	@Override
	public List<Contact> getAllContacts() {

		List<Contact> listContact = new ArrayList();
		List<ContactDetailEntity> listEntity = contactDetailsRepository.findAll();

		List<ContactDetailEntity> collect = listEntity.stream().filter(entity -> entity.getActiveSw() == "Y")
				.collect(Collectors.toList());

		if (collect.isEmpty()) {
			return Collections.emptyList();
		
		} else {
			collect.forEach(entity -> {
				Contact contact = new Contact();
				BeanUtils.copyProperties(entity, contact);
				listContact.add(contact);
			});
			return listContact;
		}
	}

	/**
	 * Get Particular Contact Number
	 */
	@Override
	public Contact getContactById(Integer cid) {
		Optional<ContactDetailEntity> optional = contactDetailsRepository.findById(cid);
		Contact contact = null;

		if (optional.isPresent()) {
			ContactDetailEntity entity = optional.get();
			contact = new Contact();
			BeanUtils.copyProperties(entity, contact);
		}
		return contact;
	}

	@Override
	public boolean updateContact(Contact c) {

		return false;
	}

	/**
	 * Delete Particular Contact Number
	 */
	@Override
	public boolean deleteContactById(Integer cid) {
		boolean flag = false;
		if (cid != null && cid != 0) {
			contactDetailsRepository.update("N", cid);
			flag = true;
		}
		return flag;
	}
       /**
        * Send Email to Receiver
        */
	@Override
	public void sendEmailByMail(String to) {
		emailUtils.sendEmail(to, "wish message", "HI Ashish How r u");
		
	}

}
