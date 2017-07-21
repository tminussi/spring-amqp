package com.javaonthecloud.rabbit;

import com.javaonthecloud.rabbit.config.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by thales on 15/07/17.
 */
@Component
public class RabbitMqProducer {

    private final RabbitTemplate rabbitTemplate;

    private final RabbitMqReceiver receiver;


    @Autowired
    public RabbitMqProducer(RabbitTemplate rabbitTemplate, RabbitMqReceiver receiver) {
        this.rabbitTemplate = rabbitTemplate;
        this.receiver = receiver;
    }

    public void sendMessage() throws InterruptedException {
        rabbitTemplate.convertAndSend(RabbitConfig.RABBIT_QUEUE, "Hello rabbit");
        receiver.getLatch().await(10, TimeUnit.SECONDS);
    }
}
