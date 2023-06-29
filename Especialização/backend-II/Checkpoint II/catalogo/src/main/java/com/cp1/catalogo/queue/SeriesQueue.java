package com.cp1.catalogo.queue;

import com.cp1.catalogo.entity.Filme;
import com.cp1.catalogo.entity.Series;
import com.cp1.catalogo.service.FilmeService;
import com.cp1.catalogo.service.SeriesService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SeriesQueue {

    @Autowired
    private SeriesService service;

    @RabbitListener(queues = {"${queue.serie}"})
    public void listen(Series series){
        if(service.findById(series.getId()).isEmpty()) {
            service.addSerie(series);
            System.out.println("Serie adicionada");
            System.out.println(series);
        }
    }
}
