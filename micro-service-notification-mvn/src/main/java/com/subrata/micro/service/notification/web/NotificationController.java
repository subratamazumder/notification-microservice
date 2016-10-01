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

import com.subrata.micro.service.notification.domain.Notification;
import com.subrata.micro.service.notification.service.MailService;
import com.subrata.micro.service.notification.service.QueueService;
import com.subrata.micro.service.notification.util.NotificationMessageProducer;

@RestController

public class NotificationController {
	private Logger logger = LoggerFactory.getLogger(NotificationController.class);
	@Autowired
	private QueueService queueService;
//	@RequestMapping(value = "/notification", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
//    public ResponseEntity<?> sendNotification(@RequestBody String reqBody) {
//		String queueName = "test-q";
//		//QueueService queueService = new QueueServiceImpl(queueName,"subrata-laptop");
//		queueService.sendMessage(reqBody.toString());
//		return new ResponseEntity<>("message: "+reqBody.toString()+" has been  published to : "+queueName, HttpStatus.ACCEPTED);
//        
//    }
//	@RequestMapping(value = "/notification1", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
//    public ResponseEntity<?> sendNotificationTest(@RequestBody Notification reqBody) {
//		try {
//		
//		mailService.sendMail(reqBody.getRecipientEmail(),reqBody.getRecipientName(), reqBody.getCommunicationType(),reqBody.getApplicationNo());
//		
//		}catch (MailException mex){
//			logger.info(mex.getLocalizedMessage());
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		return new ResponseEntity<>(HttpStatus.ACCEPTED);
//        
//    }
	@RequestMapping(value = "/notification", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public ResponseEntity<?> sendNotificationQueue(@RequestBody Notification reqBody) {
		try {
			queueService.publishMessage(reqBody);	
		}catch (Exception ex){
			logger.info(ex.getLocalizedMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
        
    }
//	@RequestMapping(value = "/notification1", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
//    public ResponseEntity<?> getNotificationTest() {
//		//public Notification(String recipientName,String recipientEmail,String communicationType,String applicationNo)
//		Notification notification = new Notification("Rimpa Paul","rimpapaul1988@gmail.com","application-received","1234567812345678");
//		return new ResponseEntity<>(notification, HttpStatus.OK);
//        
//    }
}
