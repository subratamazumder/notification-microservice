package com.wipro.micro.service.notification;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.subrata.micro.service.notification.service.impl.DataServiceImpl;



@Transactional
public class DataServiceImplTest extends MicroServiceNotificationApplicationTests {
@Autowired 
private DataServiceImpl dataService;

@Before
public void setUp(){
	
}
@After
public void tearDown(){
	
}
@Test
public void fetchNoitifcationTemplate(){
	try {
		String template = dataService.fetchNoitifcationTemplate("email");
		Assert.assertNotNull(template);
//		Assert.asserteq
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
