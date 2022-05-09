package com.example.consumer.controller;

import com.example.consumer.service.ConsumerService;
import com.example.consumer.service.ConsumerService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("consumer")
@RestController
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @Autowired
    private ConsumerService2 consumerService2;

    @RequestMapping("getName")
    public String getName(){
        return consumerService.getName();
    }

    @RequestMapping("getName1")
    public String getName1(){
       return consumerService2.getName1();
    }
}
