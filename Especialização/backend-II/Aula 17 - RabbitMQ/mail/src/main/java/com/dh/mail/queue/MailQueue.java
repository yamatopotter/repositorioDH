package com.dh.mail.queue;

import com.dh.mail.service.MailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MailQueue {

    @Autowired
    private MailService service;

    @RabbitListener(queues = {"${queue.mail}"})
    public void listen(String user){
        service.sendEmail(user);
    }
}
