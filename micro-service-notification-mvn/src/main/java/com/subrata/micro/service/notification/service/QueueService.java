package com.subrata.micro.service.notification.service;

public interface QueueService {
public void sendMessage(String message);
public void receiveMessage();
}
