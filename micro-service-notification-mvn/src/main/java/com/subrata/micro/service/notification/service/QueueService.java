package com.subrata.micro.service.notification.service;

import com.subrata.micro.service.notification.domain.Notification;

public interface QueueService {
public void publishMessage(Notification notificationMessage);
}
