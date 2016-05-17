package com.subrata.micro.service.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.subrata.micro.service.notification.dao.NotificationTemplateRepository;
import com.subrata.micro.service.notification.domain.NotificationTemplate;
import com.subrata.micro.service.notification.service.QueueService;


@SpringBootApplication

public class MicroServiceNotificationApplication implements CommandLineRunner {
//public class MicroServiceNotificationApplication {
//	@Autowired
//	NotificationTemplateRepository repository;
	
	@Autowired
	private QueueService queueService;
	public static void main(String[] args) {
		SpringApplication.run(MicroServiceNotificationApplication.class, args);	
	}
	@Override
	public void run(String... args) throws Exception {
		
//		try {
//			MongoDAO mongoDAO = new MongoDAO();
//			String templateBody = mongoDAO.fetchTemplate("sms");
//			System.out.println("SMS>"+templateBody);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
//		System.out.println("notificationTemplate found with findAll():");
//		System.out.println("-------------------------------");
//		for (NotificationTemplate notificationTemplate : repository.findAll()) {
//			System.out.println(notificationTemplate);
//		}
//		
//		System.out.println("notificationTemplate found with findByType():");
//		System.out.println("-------------------------------");
//		System.out.println("SMS>"+repository.findByType("sms"));
//			
//		System.out.println();
		
		
		System.out.println("Receiver thread started from git some more text......");
		queueService.receiveMessage();
		
		
	}
}
