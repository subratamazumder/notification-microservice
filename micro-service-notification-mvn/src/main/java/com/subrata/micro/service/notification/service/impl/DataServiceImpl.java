package com.subrata.micro.service.notification.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subrata.micro.service.notification.dao.NotificationTemplateRepository;
import com.subrata.micro.service.notification.service.DataService;

@Service
public class DataServiceImpl implements DataService {
	@Autowired
	private NotificationTemplateRepository notificationRepository;

	@Override
	public String fetchNoitifcationTemplate(String notifcationType) throws Exception {
		try {
			if (notificationRepository != null)
				return notificationRepository.findByType(notifcationType).getBody();
			else {
				throw new Exception("notificationRepository not instantiated");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
