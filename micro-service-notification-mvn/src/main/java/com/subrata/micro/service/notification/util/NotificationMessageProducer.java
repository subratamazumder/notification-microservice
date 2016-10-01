package com.subrata.micro.service.notification.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.subrata.micro.service.notification.domain.Notification;

@Component
public class NotificationMessageProducer {
	private Logger logger = LoggerFactory.getLogger(NotificationMessageProducer.class);
	private RabbitTemplate rabbitTemplate;

	@Autowired // RabbitTemplate is already available in context
	public NotificationMessageProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public void produceMessage(Notification notificationMessage) throws AmqpException {
		logger.info("Publishing notificationMessage for application-" + notificationMessage.getApplicationNo());
		rabbitTemplate.convertAndSend(notificationMessage);
	}
}
