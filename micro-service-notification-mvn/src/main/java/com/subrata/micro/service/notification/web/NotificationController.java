package com.subrata.micro.service.notification.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.subrata.micro.service.notification.service.QueueService;

@RestController

public class NotificationController {
	@Autowired
	private QueueService queueService;
	@RequestMapping(value = "/notification", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public ResponseEntity<?> sendNotification(@RequestBody String reqBody) {
		String queueName = "test-q";
		//QueueService queueService = new QueueServiceImpl(queueName,"subrata-laptop");
		queueService.sendMessage(reqBody.toString());
		return new ResponseEntity<>("message: "+reqBody.toString()+" has been  published to : "+queueName, HttpStatus.CREATED);
        
    }
}
