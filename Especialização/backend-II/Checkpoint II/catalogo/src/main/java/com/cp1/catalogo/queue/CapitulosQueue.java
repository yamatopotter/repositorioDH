package com.cp1.catalogo.queue;

import com.cp1.catalogo.entity.Capitulos;
import com.cp1.catalogo.entity.Temporadas;
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
        Optional<Temporadas> temporada = temporadasService.findById(capitulos.getTemporada().getId());
        if(temporada.isEmpty()){
            if(seriesService.findById(capitulos.getTemporada().getSerie().getId()).isEmpty()) {
                seriesService.addSerie(capitulos.getTemporada().getSerie());
                System.out.println("Serie adicionada");
                System.out.println(capitulos.getTemporada().getSerie());
            }
            temporadasService.addTemporada(capitulos.getTemporada());
            System.out.println("Temporada adicionada");
            System.out.println(capitulos.getTemporada());
        }
        service.addCapitulo(capitulos);
        System.out.println("Capitulo adicionado");
        System.out.println(capitulos);
    }
}
