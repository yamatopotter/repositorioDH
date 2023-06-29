package com.cp1.series.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQSenderConfig {

    @Value("${queue.serie}")
    private String queueSerie;

    @Value("${queue.capitulo}")
    private String queueCapitulo;

    @Value("${queue.temporada}")
    private String queueTemporada;
    @Bean
    public Queue SerieQueue() {
        return new Queue(this.queueSerie,false);
    }

    @Bean
    public Queue TemporadaQueue() {
        return new Queue(this.queueCapitulo,false);
    }

    @Bean
    public Queue CaptuloQueue() {
        return new Queue(this.queueTemporada,false);
    }

}
