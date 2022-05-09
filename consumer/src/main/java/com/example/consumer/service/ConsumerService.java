package com.example.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumerService {

    /**
     * 调用方式一：
     * 使用RestTemplate调用注册子模块接口方法
     */

    @Autowired
    private RestTemplate restTemplate;

    public String getName(){
        String name=restTemplate.getForObject("http://server-provider/test/getName",String.class);
        return name;
    }
}
