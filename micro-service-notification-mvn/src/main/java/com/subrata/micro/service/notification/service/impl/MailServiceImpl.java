package com.subrata.micro.service.notification.service.impl;

import com.subrata.micro.service.notification.service.MailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
	private JavaMailSender javaMailSender;
	@Autowired
	public MailServiceImpl(JavaMailSender javaMailSender){
		this.javaMailSender = javaMailSender;
	}
	@Override
	public void sendMail(String toMailId, String subject, String body) throws MailException {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(toMailId);
		mailMessage.setFrom("subrata.poc@gmail.com");
		mailMessage.setSubject(subject);
		mailMessage.setText(body);
		
		javaMailSender.send(mailMessage);
	}

	@Override
	public void sendSMS(String toMobileNo, String subject, String body) {
		// TODO Auto-generated method stub
		
	}

}
