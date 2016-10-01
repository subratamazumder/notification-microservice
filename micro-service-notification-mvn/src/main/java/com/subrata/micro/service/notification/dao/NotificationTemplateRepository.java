package com.subrata.micro.service.notification.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.subrata.micro.service.notification.domain.NotificationTemplate;

public interface NotificationTemplateRepository  extends MongoRepository<NotificationTemplate, String>{
	
	public NotificationTemplate findByTypeAndCommunicationType(String type,String communicationType);
	public NotificationTemplate findByType(String type);

}
