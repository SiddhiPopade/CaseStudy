package com.booking.controller;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.booking.config.MQConfig;
import com.booking.models.Display;
import com.booking.repository.BookingRepository;

@RestController
public class RabbitMqController {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	private RabbitTemplate template;

	// Method to produce message
	@PostMapping("/publish")
	public String publishMessage(@RequestBody Display message) {
		message.setMessageId(UUID.randomUUID().toString());
		template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, message);

		return "Booking Successful";
	}

}
