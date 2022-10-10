package com.checkIn.api.consumer;

import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Component
public class MessageListner {

	/*@RabbitListener(queues = MQConfig.QUEUE)
    public void listener(Display message) {
        System.out.println(message);
    }*/
}

