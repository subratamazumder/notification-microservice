package com.subrata.micro.service.notification.service.impl;

import com.subrata.micro.service.notification.service.MailService;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
	private JavaMailSender javaMailSender;

	@Autowired
	public MailServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	/**
	 * HTML Mail
	 */
	@Override
	public void sendMail(String toMailId,String fromMailId,String subject, String body) throws MailException {
		MimeMessage mailMessage;
		try {
			mailMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mailMessage, true);
			helper.setTo(toMailId);
			helper.setText(body,
					true);
			FileSystemResource res = new FileSystemResource(new ClassPathResource("static/demo-bank-logo-no-bckg.png").getFile());//(;//("classpath:/resources/static/"));
			helper.addInline("identifier1234", res);
			helper.setFrom(fromMailId);
			helper.setSubject(subject);
			javaMailSender.send(mailMessage);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 * Simple Mail
	 */
	// public void sendMail(String toMailId,String recipientName, String
	// subject, String body) throws MailException {
	// SimpleMailMessage mailMessage = new SimpleMailMessage();
	// mailMessage.setTo(toMailId);
	// mailMessage.setFrom("subrata.poc@gmail.com");
	// mailMessage.setSubject(subject);
	// mailMessage.setText("Hello "+recipientName+"\n"+body);
	//
	// javaMailSender.send(mailMessage);
	// }

	@Override
	public void sendSMS(String toMobileNo, String subject, String body) {
		// TODO Auto-generated method stub

	}

}
