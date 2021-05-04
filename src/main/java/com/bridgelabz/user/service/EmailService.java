package com.bridgelabz.user.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

	  private JavaMailSender javaMailSender;

	    public EmailService(JavaMailSender javaMailSender) {
	        this.javaMailSender = javaMailSender;
	    }

	    public void sendMail(String toEmail, String subject, String message) {
//	    	System.out.println("aaaaaaaaa"+toEmail);
//	    	System.out.println("aaaaaaaaa"+subject);
//	    	System.out.println("aaaaaaaaa"+message);
	    	SimpleMailMessage mailMessage = new SimpleMailMessage();

	        mailMessage.setTo(toEmail);
	        mailMessage.setSubject(subject);
	        mailMessage.setText(message);
	     
	       //s mailMessage.setText("email verified successfuly");
	        //mailMessage.setFrom("fundoo2019@gmail.com");

	        javaMailSender.send(mailMessage);
	    }
	
}
