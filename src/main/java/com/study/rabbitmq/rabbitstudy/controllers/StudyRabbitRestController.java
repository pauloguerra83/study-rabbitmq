package com.study.rabbitmq.rabbitstudy.controllers;

import com.study.rabbitmq.rabbitstudy.senders.RabbitMQSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class StudyRabbitRestController {

    @Autowired
	RabbitMQSender rabbitMQSender;

	@PostMapping(value = "/producer")
	public String producer(@RequestBody String empName) {
	
		rabbitMQSender.send(empName);

		return "Message sent to the RabbitMQ JavaInUse Successfully";
	}

    
}
