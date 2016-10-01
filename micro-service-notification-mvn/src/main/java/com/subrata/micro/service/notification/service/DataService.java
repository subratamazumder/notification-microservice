package com.subrata.micro.service.notification.service;

import com.subrata.micro.service.notification.domain.NotificationTemplate;

public interface DataService {
	public String fetchNoitifcationTemplate(String notifcationType) throws Exception;
	public NotificationTemplate fetchNoitifcationTemplate(String notifcationType,String communicationType) throws Exception;
}
