package com.cp1.filmes.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQSenderConfig {

    @Value("${queue.filme}")
    private String queueFilme;

    @Bean
    public Queue FilmeQueue() {
        return new Queue(this.queueFilme,false);
    }

}
