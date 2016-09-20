package com.subrata.micro.service.notification.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.subrata.micro.service.notification.service.MailService;
import com.subrata.micro.service.notification.service.QueueService;

@RestController

public class NotificationController {
	private Logger logger = LoggerFactory.getLogger(NotificationController.class);
	@Autowired
	private QueueService queueService;
	@Autowired
	private MailService mailService;
	@RequestMapping(value = "/notification", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public ResponseEntity<?> sendNotification(@RequestBody String reqBody) {
		String queueName = "test-q";
		//QueueService queueService = new QueueServiceImpl(queueName,"subrata-laptop");
		queueService.sendMessage(reqBody.toString());
		return new ResponseEntity<>("message: "+reqBody.toString()+" has been  published to : "+queueName, HttpStatus.CREATED);
        
    }
	@RequestMapping(value = "/notification1", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public ResponseEntity<?> sendNotificationTest(@RequestBody String reqBody) {
		String toMailId = "subrata.besu@gmail.com";
		try {
		
		mailService.sendMail(toMailId,"subject-test",reqBody.toString());
		
		}catch (MailException mex){
			logger.info(mex.getLocalizedMessage());
		}
		return new ResponseEntity<>("message: "+reqBody.toString()+" has been  published to : "+toMailId, HttpStatus.CREATED);
        
    }
}
