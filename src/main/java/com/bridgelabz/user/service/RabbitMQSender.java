package com.bridgelabz.user.service;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	//@Value("${javainuse.rabbitmq.exchange}")
		String exchange = "javainuse.exchange";

		//@Value("${javainuse.rabbitmq.routingkey}")
		private String routingkey = "javainuse.routingkey";
	
	public void send(String abc) {
		rabbitTemplate.convertAndSend(exchange, routingkey, abc);
		System.out.println("Send msg = " + abc);
	    
	}
}
