package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.domain.Contact;
import com.example.service.ContactService;

/**
 * 
 * @author Ashish
 * @version 1.0
 * @since 22.12.2019
 */


@Controller
public class ViewContactController {
	
	@Autowired
	private ContactService contactService;
	
	/**
	 * Modify Contact Number
	 */
	@RequestMapping(value="/editContact",method=RequestMethod.GET)
	public String editContact(HttpServletRequest req,Model model) {
		Contact contacts=null; 
		String cid = req.getParameter("cnctId");
		if (cid != null && !"".equals(cid)) {
		    	int contId = Integer.parseInt(cid);
		    	contacts = contactService.getContactById(contId);
		    }
		    model.addAttribute("contact", contacts);
		return "contact";
	}
	 
	/**
	 * Delete Contact Number
	 */
	@RequestMapping(value="/deleteContact",method=RequestMethod.GET)
	public String deleteContact(HttpServletRequest req) {
		 String cid = req.getParameter("cnctId");
		    if(cid!=null && !"".equals(cid)) {
		    	int contId = Integer.parseInt(cid);
		  contactService.deleteContactById(contId);
		    
		    }
		return "redirect:/getAllRecord";
	}
}
