package com.example.consumer.controller;

import com.example.consumer.service.ConsumerService;
import com.example.consumer.service.ConsumerService2;
import com.example.consumer.service.MailSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RequestMapping("consumer")
@RestController
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @Autowired
    private ConsumerService2 consumerService2;

    @Autowired
    private MailSendService mailSendService;

    @RequestMapping("getName")
    public String getName(){
        return consumerService.getName();
    }

    @RequestMapping("getName1")
    public String getName1(){
       return consumerService2.getName1();
    }

    //发送邮件
    @RequestMapping("sendMail")
    public String sendMail(){
        String acceptor="yewc@ramaxel.com";
        String title="得闲？";
        String context="好得闲？";
        mailSendService.sendMail(acceptor,title,context);
        return "成功";
    }



    //定时发送邮件
    /* 为完善
       开启关闭问题
    @Scheduled(cron = "0/30 * * * * ? ")
    @RequestMapping("sendMail2")
    public String sendMailScheduled(){
        Date date=new Date();
        SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd zz hh:mm:ss EE");
        String acceptor="1219646159@qq.com";
        String title="得闲？";
        String context="你现在"+time.format(date)+"系唔系好得闲？";
        mailSendService.sendMail(acceptor,title,context);
        return "开始定时发送邮件任务";
    }*/
}
