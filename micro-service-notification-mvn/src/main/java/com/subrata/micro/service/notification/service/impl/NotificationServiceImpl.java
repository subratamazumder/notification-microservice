package com.subrata.micro.service.notification.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.subrata.micro.service.notification.domain.Notification;
import com.subrata.micro.service.notification.domain.NotificationTemplate;
import com.subrata.micro.service.notification.service.DataService;
import com.subrata.micro.service.notification.service.NotificationService;
import com.subrata.micro.service.notification.service.MailService;

@Service
public class NotificationServiceImpl implements NotificationService {
	private Logger logger = LoggerFactory.getLogger(NotificationService.class);
	@Value("${notification.service.mail.fromid}")
	private String fromMailId;
	@Value("${notification.service.mail.template.default.notification.type}")
	private String defaultNotificationType;

	@Value("${notification.service.mail.template.contactno}")
	private String customerCareNo;
	private DataService dataService;
	private MailService mailService;

	@Autowired
	public NotificationServiceImpl(DataService dataService, MailService mailService) {
		this.dataService = dataService;
		this.mailService = mailService;
	}

	@Override
	public void sendNotification(Notification notification) {
		logger.info("sendNotification....start");
		Map<String, String> keyValMapHeader = new HashMap<String, String>();
		Map<String, String> keyValMapBody = new HashMap<String, String>();
		try {
			NotificationTemplate template = dataService.fetchNoitifcationTemplate(defaultNotificationType,
					notification.getCommunicationType());
			keyValMapHeader.put("#APP_ID#", notification.getApplicationNo());

			keyValMapBody.put("#USER#", notification.getRecipientName());
			keyValMapBody.put("#CONTACT#", customerCareNo);
			keyValMapBody.put("#APPN_ID#", notification.getApplicationNo());

			mailService.sendMail(notification.getRecipientEmail(), fromMailId,
					replaceKeyValue(template.getSubject(), keyValMapHeader),
					replaceKeyValue(template.getBody(), keyValMapBody));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("sendNotification....end");
	}

	private String replaceKeyValue(String text, Map<String, String> keyValMap) {
		logger.info("replaceKeyValue....-"+text);
		for (Map.Entry<String, String> entry : keyValMap.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			if (null!= value)
				text = text.replace(key,value);
		}
		logger.info("replaceKeyValue....end-"+text);
		return text;
	}

}
