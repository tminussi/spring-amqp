package com.javaonthecloud.rabbit;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * Created by thales on 15/07/17.
 */
@Component
public class RabbitMqReceiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) throws InterruptedException {
        Thread.sleep(10000);
        System.out.println(message);
        System.out.println("test");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
