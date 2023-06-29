package com.cp1.catalogo.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQSenderConfig {

    @Value("${queue.filme}")
    private String queueFilme;

    @Value("${queue.serie}")
    private String queueSerie;

    @Value("${queue.temporada}")
    private String queueTemporada;

    @Value("${queue.capitulo}")
    private String queueCapitulo;

    @Bean
    public Queue FilmeQueue() {
        return new Queue(this.queueFilme,false);
    }

    @Bean
    public Queue SerieQueue() {
        return new Queue(this.queueSerie,false);
    }

    @Bean
    public Queue TemporadaQueue() {
        return new Queue(this.queueTemporada,false);
    }

    @Bean
    public Queue CapituloQueue() {
        return new Queue(this.queueCapitulo,false);
    }

}
