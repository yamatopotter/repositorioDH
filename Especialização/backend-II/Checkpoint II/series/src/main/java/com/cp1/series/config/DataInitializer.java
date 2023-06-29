package com.cp1.series.config;

import com.cp1.series.entity.Capitulos;
import com.cp1.series.entity.Series;
import com.cp1.series.entity.Temporadas;
import com.cp1.series.service.CapitulosService;
import com.cp1.series.service.SeriesService;
import com.cp1.series.service.TemporadasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    @Autowired
    private SeriesService seriesService;
    @Autowired
    private TemporadasService temporadasService;
    @Autowired
    private CapitulosService capitulosService;


//    public DataInitializer(SeriesService seriesService, TemporadasService temporadasService, CapitulosService capitulosService) {
//        this.seriesService = seriesService;
//        this.temporadasService = temporadasService;
//        this.capitulosService = capitulosService;
//    }

    @PostConstruct
    public void init() {
        // Inserir dados iniciais no H2

        Series serie = seriesService.addSerie(new Series(null, "Friends", "Comédia")).get();
        try {
            Thread.sleep(2000); // 2000 milissegundos = 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Temporadas temporada = temporadasService.addTemporada(new Temporadas(null, serie, 1)).get();
        try {
            Thread.sleep(2000); // 2000 milissegundos = 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 1; i <= 10; i++) {
            Capitulos capitulo = new Capitulos();
            capitulo.setTemporada(temporada);
            capitulo.setName("Capítulo " + i);
            capitulo.setNumero(i);
            capitulo.setUrlStream("http://exemplo.com/capitulo" + i);

            capitulosService.addCapitulo(capitulo);
        }

        temporada = temporadasService.addTemporada(new Temporadas(null, serie, 2)).get();
        try {
            Thread.sleep(2000); // 2000 milissegundos = 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 1; i <= 10; i++) {
            Capitulos capitulo = new Capitulos();
            capitulo.setTemporada(temporada);
            capitulo.setName("Capítulo " + i);
            capitulo.setNumero(i);
            capitulo.setUrlStream("http://exemplo.com/capitulo" + i);

            capitulosService.addCapitulo(capitulo);
        }

        serie = seriesService.addSerie(new Series(null, "The Strain", "Terror")).get();
        try {
            Thread.sleep(2000); // 2000 milissegundos = 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        temporada = temporadasService.addTemporada(new Temporadas(null, serie, 1)).get();
        try {
            Thread.sleep(2000); // 2000 milissegundos = 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 1; i <= 10; i++) {
            Capitulos capitulo = new Capitulos();
            capitulo.setTemporada(temporada);
            capitulo.setName("Capítulo " + i);
            capitulo.setNumero(i);
            capitulo.setUrlStream("http://exemplo.com/capitulo" + i);

            capitulosService.addCapitulo(capitulo);
        }

        temporada = temporadasService.addTemporada(new Temporadas(null, serie, 2)).get();
        try {
            Thread.sleep(2000); // 2000 milissegundos = 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 1; i <= 10; i++) {
            Capitulos capitulo = new Capitulos();
            capitulo.setTemporada(temporada);
            capitulo.setName("Capítulo " + i);
            capitulo.setNumero(i);
            capitulo.setUrlStream("http://exemplo.com/capitulo" + i);

            capitulosService.addCapitulo(capitulo);
        }

    }
}