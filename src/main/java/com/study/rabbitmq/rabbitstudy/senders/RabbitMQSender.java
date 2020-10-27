package com.study.rabbitmq.rabbitstudy.senders;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQSender {

    @Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${studyrabbit.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${studyrabbit.rabbitmq.routingkey}")
	private String routingkey;	
	
	public void send(String company) {
		rabbitTemplate.convertAndSend(exchange, routingkey, company);
		System.out.println("Send msg = " + company);	    
	}
    
}
