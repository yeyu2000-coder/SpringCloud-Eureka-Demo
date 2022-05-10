package com.example.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "yeyu-cloud-serve-mail")
public interface MailSendService {
    @GetMapping("mail/sendMail")
    public void sendMail(@RequestParam("acceptor")String acceptor,
                         @RequestParam("title")String title,
                         @RequestParam("context")String context);

}
