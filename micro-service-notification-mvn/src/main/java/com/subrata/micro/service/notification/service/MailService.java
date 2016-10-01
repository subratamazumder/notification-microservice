package com.subrata.micro.service.notification.service;

import org.springframework.mail.MailException;

public interface MailService {
	public void sendMail(String toMailId,String fromMailId, String subject, String body) throws MailException;
	public void sendSMS(String toMobileNo, String subject, String body);
}
