package com.subrata.micro.service.notification.util;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.subrata.micro.service.notification.domain.Notification;
import com.subrata.micro.service.notification.service.NotificationService;

@Component
public class NotificationMessageReceiver {
	private NotificationService notificationService;
	@Autowired
	public NotificationMessageReceiver(NotificationService notificationService){
		this.notificationService=notificationService;;
	}
	private Logger logger = LoggerFactory.getLogger(NotificationMessageReceiver.class);
	public void handleMessage(Notification notification) {
		logger.info("Message received-" + notification.getApplicationNo());
		notificationService.sendNotification(notification);
	}
	public void handleMessage(String notificationJson) {
		
		ObjectMapper mapper = new ObjectMapper();
		Notification notification;
		try {
			notification = mapper.readValue(notificationJson, Notification.class);
			logger.info("Message received-" + notification.getApplicationNo());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		notificationService.sendNotification(notification);
	}
}
