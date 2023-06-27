package com.cp1.series.config;

import com.cp1.series.entity.Capitulos;
import com.cp1.series.entity.Series;
import com.cp1.series.entity.Temporadas;
import com.cp1.series.repository.CapitulosRepository;
import com.cp1.series.repository.SeriesRepository;
import com.cp1.series.repository.TemporadasRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    private final SeriesRepository seriesRepository;
    private final TemporadasRepository temporadasRepository;
    private final CapitulosRepository capitulosRepository;


    public DataInitializer(SeriesRepository seriesRepository, TemporadasRepository temporadasRepository, CapitulosRepository capitulosRepository) {
        this.seriesRepository = seriesRepository;
        this.temporadasRepository = temporadasRepository;
        this.capitulosRepository = capitulosRepository;
    }

    @PostConstruct
    public void init() {
        // Inserir dados iniciais no H2
        Series serie1 = new Series(null, "Friends", "Comédia");
        seriesRepository.save(serie1);

        Temporadas temporada1 = new Temporadas(null, serie1, 1);
        temporadasRepository.save(temporada1);

        for (int i = 1; i <= 10; i++) {
            Capitulos capitulo = new Capitulos();
            capitulo.setTemporada(temporada1);
            capitulo.setName("Capítulo " + i);
            capitulo.setNumero(i);
            capitulo.setUrlStream("http://exemplo.com/capitulo" + i);

            capitulosRepository.save(capitulo);
        }

        Temporadas temporada2 = new Temporadas(null, serie1, 2);
        temporadasRepository.save(temporada2);

        for (int i = 1; i <= 10; i++) {
            Capitulos capitulo = new Capitulos();
            capitulo.setTemporada(temporada2);
            capitulo.setName("Capítulo " + i);
            capitulo.setNumero(i);
            capitulo.setUrlStream("http://exemplo.com/capitulo" + i);

            capitulosRepository.save(capitulo);
        }

        Series serie2 = new Series(null, "The Strain", "Terror");
        seriesRepository.save(serie2);

        Temporadas temporada3 = new Temporadas(null, serie2, 1);
        temporadasRepository.save(temporada3);

        for (int i = 1; i <= 10; i++) {
            Capitulos capitulo = new Capitulos();
            capitulo.setTemporada(temporada3);
            capitulo.setName("Capítulo " + i);
            capitulo.setNumero(i);
            capitulo.setUrlStream("http://exemplo.com/capitulo" + i);

            capitulosRepository.save(capitulo);
        }

        Temporadas temporada4 = new Temporadas(null, serie2, 2);
        temporadasRepository.save(temporada4);

        for (int i = 1; i <= 10; i++) {
            Capitulos capitulo = new Capitulos();
            capitulo.setTemporada(temporada4);
            capitulo.setName("Capítulo " + i);
            capitulo.setNumero(i);
            capitulo.setUrlStream("http://exemplo.com/capitulo" + i);

            capitulosRepository.save(capitulo);
        }

    }
}