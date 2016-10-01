package com.subrata.micro.service.notification.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
public class RabbitMQProducerConfigurationUtil extends RabbitMQConfigurationUtil {
	@Autowired
	private ConnectionFactory connectionFactory;
	@Bean //RabbitTemplate is uploaded back to context
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);;
		rabbitTemplate.setRoutingKey(queueName);
		rabbitTemplate.setQueue(queueName);
		rabbitTemplate.setMessageConverter(jsonMessageConverter());
		return rabbitTemplate;
	}
}
