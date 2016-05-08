package com.wipro.micro.service.notification;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import com.subrata.micro.service.notification.MicroServiceNotificationApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MicroServiceNotificationApplication.class)
@WebAppConfiguration
public class MicroServiceNotificationApplicationTests {

	@Test
	public void contextLoads() {
	}

}
