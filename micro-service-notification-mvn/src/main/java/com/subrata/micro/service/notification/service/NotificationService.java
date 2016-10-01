package com.subrata.micro.service.notification.service;

import com.subrata.micro.service.notification.domain.Notification;

public interface NotificationService {
	public void sendNotification(Notification notification);
}
