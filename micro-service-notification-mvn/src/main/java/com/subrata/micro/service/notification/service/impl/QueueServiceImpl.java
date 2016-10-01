package com.subrata.micro.service.notification.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subrata.micro.service.notification.domain.Notification;
import com.subrata.micro.service.notification.service.QueueService;
import com.subrata.micro.service.notification.util.NotificationMessageProducer;

@Service
public class QueueServiceImpl implements QueueService {
	private Logger logger = LoggerFactory.getLogger(QueueServiceImpl.class);
	private NotificationMessageProducer notificationMessageProducer;

	@Autowired
	public QueueServiceImpl(NotificationMessageProducer notificationMessageProducer) {
		this.notificationMessageProducer = notificationMessageProducer;
	}

	@Override
	public void publishMessage(Notification notificationMessage) {
		try {
			logger.info("publishing message for application-"+notificationMessage.getApplicationNo());
			notificationMessageProducer.produceMessage(notificationMessage);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
