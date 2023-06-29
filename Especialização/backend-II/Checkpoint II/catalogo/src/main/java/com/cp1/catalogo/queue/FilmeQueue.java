package com.cp1.catalogo.queue;

import com.cp1.catalogo.entity.Filme;
import com.cp1.catalogo.service.FilmeService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FilmeQueue {

    @Autowired
    private FilmeService service;

    @RabbitListener(queues = {"${queue.filme}"})
    public void listen(Filme filme){
        service.addFilme(filme);
    }
}
