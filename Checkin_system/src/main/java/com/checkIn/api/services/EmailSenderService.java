package com.checkIn.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendSimpleEmail(String toEmail,String subject,String body)
	{
		SimpleMailMessage msg = new SimpleMailMessage();
		
		msg.setFrom("pranitajagdale9@gmail.com");
		msg.setTo(toEmail);
		msg.setSubject(subject);
		msg.setText(body);
		
		mailSender.send(msg);
		System.out.println("Mail send...");
	}
}
