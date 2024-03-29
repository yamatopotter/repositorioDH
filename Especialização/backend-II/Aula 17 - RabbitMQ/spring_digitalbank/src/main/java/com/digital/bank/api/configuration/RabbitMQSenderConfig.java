package com.digital.bank.api.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQSenderConfig {

    @Value("${queue.mail}")
    private String queueMail;

    @Bean
    public Queue MailQueue() {
        return new Queue(this.queueMail,false);
    }

}
