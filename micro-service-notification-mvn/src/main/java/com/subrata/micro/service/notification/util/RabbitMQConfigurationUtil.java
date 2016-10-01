package com.subrata.micro.service.notification.util;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.subrata.micro.service.notification.domain.Notification;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JavaTypeMapper.TypePrecedence;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
@Configuration
public class RabbitMQConfigurationUtil {
	
	@Value("${notification.service.rabbitmq.queuename}")
	protected String queueName;
	@Value("${notification.service.rabbitmq.exchangename}")
	private String exchangeName;
	
	public RabbitMQConfigurationUtil(){
		
	}
    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(exchangeName);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(queueName);
    }
    @Bean
    public MessageConverter jsonMessageConverter()
    {
        
//    	final Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
//        converter.setClassMapper(classMapper());
//        converter.setTypePrecedence(TypePrecedence.TYPE_ID);
//        Jackson2JavaTypeMapper mapper = new 
//        converter.set
       // return converter;
        return new Jackson2JsonMessageConverter();
    }

//    @Bean
//    public DefaultClassMapper classMapper()
//    {
//        DefaultClassMapper typeMapper = new DefaultClassMapper();
////        typeMapper.setDefaultType(Notification.class);
//      Map<String, Class<?>> idClassMapping = new HashMap<String, Class<?>>();
//      idClassMapping.put("notification", Notification.class);
//      typeMapper.setIdClassMapping(idClassMapping);
//        return typeMapper;
//    }
}
