package com.ankit.activemq.producer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQProducer implements CommandLineRunner {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	private String destination="myqueue1";

	@Override
	public void run(String... args) throws Exception {
		jmsTemplate.send(destination, new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				Message message=session.createTextMessage("My name is ankit");
				return message;
			}
		});
		
		
	}

}
