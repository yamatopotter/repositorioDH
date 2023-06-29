package com.cp1.catalogo.queue;

import com.cp1.catalogo.entity.Capitulos;
import com.cp1.catalogo.service.CapitulosService;
import com.cp1.catalogo.service.SeriesService;
import com.cp1.catalogo.service.TemporadasService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CapitulosQueue {

    @Autowired
    private CapitulosService service;
    @Autowired
    private TemporadasService temporadasService;
    @Autowired
    private SeriesService seriesService;

    @RabbitListener(queues = {"${queue.capitulo}"})
    public void listen(Capitulos capitulos){
        System.out.println(capitulos);
        Optional temporada = temporadasService.findById(capitulos.getTemporada().getId());
        System.out.println(temporada.equals(null));
        if(temporada == null){
            if(seriesService.findById(capitulos.getTemporada().getSerie().getId()).equals(null)){
                seriesService.addSerie(capitulos.getTemporada().getSerie());
            }
            else{
                temporadasService.addTemporada(capitulos.getTemporada());
            }
        }
        service.addCapitulo(capitulos);
    }
}
