package com.example.yeyucloudservemail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;


@Service
public class SendMailService {

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    public void sendEmail(String acceptor,String title,String context){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);//发送者
        message.setTo(acceptor);//接收者
        message.setSubject(title);//标题
        message.setText(context);//内容
        javaMailSender.send(message);

    }
}
