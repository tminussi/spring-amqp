package com.javaonthecloud.controller;

import com.javaonthecloud.rabbit.RabbitMqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by thales on 15/07/17.
 */
@RestController
@RequestMapping("/api")
public class IndexController {

    @Autowired
    private RabbitMqProducer producer;

    @GetMapping(value = "/index")
    public void index() throws InterruptedException {
        producer.sendMessage();
    }
}
