package com.subrata.micro.service.notification.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subrata.micro.service.notification.dao.NotificationTemplateRepository;
import com.subrata.micro.service.notification.domain.NotificationTemplate;
import com.subrata.micro.service.notification.service.DataService;

@Service
public class DataServiceImpl implements DataService {
	private Logger logger = LoggerFactory.getLogger(DataServiceImpl.class);
	@Autowired
	private NotificationTemplateRepository notificationRepository;

	@Override
	public String fetchNoitifcationTemplate(String notifcationType) throws Exception {
		logger.info("fetchNoitifcationTemplate-"+notifcationType);
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
	@Override
	public NotificationTemplate fetchNoitifcationTemplate(String notifcationType,String communicationType) throws Exception {
		logger.info("fetchNoitifcationTemplate-"+notifcationType+"-"+communicationType);
		NotificationTemplate template;
		try {
			if (notificationRepository != null){
				template = notificationRepository.findByTypeAndCommunicationType(notifcationType, communicationType);
				if(template.getId()!=null)
				return template;
				else {
					throw new Exception("no template available for -"+notifcationType+"-"+communicationType);
				}
			}
			else {
				throw new Exception("notificationRepository not instantiated");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
