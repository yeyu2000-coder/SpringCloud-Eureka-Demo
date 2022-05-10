package com.example.yeyucloudservemail.controller;

import com.example.yeyucloudservemail.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("mail")
@RestController
public class MailSendController {

    @Autowired
    private SendMailService sendMailService;

    @GetMapping("sendMail")
    public void SendMail(String acceptor, String title, String context){
        sendMailService.sendEmail(acceptor, title, context);
    }
}
