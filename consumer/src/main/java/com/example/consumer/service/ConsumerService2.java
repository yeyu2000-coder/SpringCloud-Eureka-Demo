package com.example.consumer.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 调用方式二：
 * 使用@FeignClient注解调用注册子模块接口方法
 */
@FeignClient(value="server-provider")
public interface ConsumerService2 {
    @GetMapping("test/getName")
    public String getName1();
}
