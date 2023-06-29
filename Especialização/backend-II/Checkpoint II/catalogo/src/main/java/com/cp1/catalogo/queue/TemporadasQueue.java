package com.cp1.catalogo.queue;

import com.cp1.catalogo.entity.Temporadas;
import com.cp1.catalogo.service.SeriesService;
import com.cp1.catalogo.service.TemporadasService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TemporadasQueue {

    @Autowired
    private TemporadasService service;
    @Autowired
    private SeriesService seriesService;

    @RabbitListener(queues = {"${queue.temporada}"})
    public void listen(Temporadas temporadas){
        if(seriesService.findById(temporadas.getSerie().getId()).equals(null)){
            seriesService.addSerie(temporadas.getSerie());
        }
        service.addTemporada(temporadas);
    }
}
