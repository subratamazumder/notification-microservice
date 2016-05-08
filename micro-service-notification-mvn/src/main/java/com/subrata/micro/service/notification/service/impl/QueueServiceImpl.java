package com.subrata.micro.service.notification.service.impl;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.subrata.micro.service.notification.service.DataService;
import com.subrata.micro.service.notification.service.QueueService;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
@Service

public class QueueServiceImpl implements QueueService {
	@Autowired
	private DataService dataService;

	private String queueName;
	private String hostName;

	public QueueServiceImpl() {
		this.queueName = "test-q";
		this.hostName = "subrata-laptop";
	}

	public QueueServiceImpl(String queueName, String hostName) {
		this.queueName = queueName;
		this.hostName = hostName;
	}

	@Override
	public void sendMessage(String message) {
		try {
			System.out.println("Sending msg: " + message + " to queue: " + this.queueName);
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost(this.hostName);
			factory.setUsername("subrata");
			factory.setPassword("subrata");
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();
			channel.queueDeclare(this.queueName, false, false, false, null);
			channel.basicPublish("", this.queueName, null, message.getBytes());
			System.out.println(" [x] Sent '" + message + "'");
			channel.close();
			connection.close();
		} catch (IOException | TimeoutException ex) {
			ex.printStackTrace();

		}
	}

	@Override
	public void receiveMessage() {
		try {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost(this.hostName);
			factory.setUsername("subrata");
			factory.setPassword("subrata");
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();

			channel.queueDeclare(this.queueName, false, false, false, null);
			// System.out.println(" [*] Waiting for messages. To exit press
			// CTRL+C");

			Consumer consumer = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
						byte[] body) throws IOException {
					String message = new String(body, "UTF-8");
					System.out.println(" [x] Received '" + message + "'");
					try {
						
						String templateBody = dataService.fetchNoitifcationTemplate("sms");
						System.out.println("Sending with template body-"+templateBody);
						System.out.println("Sending with actual body-" + templateBody.replaceFirst("#user", message));
					} catch (Exception ex) {
						ex.printStackTrace();
					}

				}
			};
			channel.basicConsume(this.queueName, true, consumer);

		} catch (IOException | TimeoutException ex) {
			ex.printStackTrace();
		}

	}
}
