package com.example.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
@Component
public class EmailUtils {
	 @Autowired
     private JavaMailSender emailSender;
	 
	public void sendEmail(String to,String subject,String text) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(to);
		message.setSubject("wish message");
		message.setText("HI Ashish How r u");
		emailSender.send(message);
		
	}
}
