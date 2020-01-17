package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.constant.AppConfig;
import com.example.domain.Contact;
import com.example.service.ContactService;

/**
 * 
 * @author Ashish
 * @version 1.0
 * @since 22.12.2019
 */

@Controller
public class ContactInfoController {
	@Autowired
	private ContactService contactService;

	/**
	 * Display ContactNumber On Form
	 */
	@RequestMapping(value = "/")
	public String displayContactForm(Model model) {
		Contact c = new Contact();
		model.addAttribute(AppConfig.CONTACTSTR, c);
		return AppConfig.CONTACTSTR;

	}
      /**
       Save ContactNumber 
       */
	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public String handleSubmitBtn(Contact c, RedirectAttributes redirectAttribute) {
		boolean saveContact = contactService.saveContact(c);
		if (saveContact) {
			redirectAttribute.addFlashAttribute(AppConfig.SMSMSG, "Contact saved successfully");
		} else {
			redirectAttribute.addFlashAttribute(AppConfig.SMSMSG1, "Contact not saved try again...");
		}

		return "redirect:/saveContactSuccessfully";

	}
         /**
          * 
          Solved double Posting Problem
          */
	@RequestMapping(value = "/saveContactSuccessfully", method = RequestMethod.GET)
	public String savePhoneContact(Model model) {

		Contact c = new Contact();
		model.addAttribute(AppConfig.CONTACTSTR, c);

		return AppConfig.CONTACTSTR;

	}

	/**
	 * Displayed all number on the Form
	 */
	@RequestMapping(value = "/getAllRecord", method = RequestMethod.GET)
	public String viewContacts(Model model) {
		List<Contact> allContacts = contactService.getAllContacts();
		model.addAttribute("contactList", allContacts);
		return "viewContact";
	}
}
