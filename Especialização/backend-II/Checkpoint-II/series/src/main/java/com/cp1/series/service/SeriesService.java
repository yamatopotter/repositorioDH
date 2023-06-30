package com.cp1.series.service;

import com.cp1.series.dto.DTOCapitulos;
import com.cp1.series.dto.DTOSeries;
import com.cp1.series.dto.DTOTemporadas;
import com.cp1.series.entity.Capitulos;
import com.cp1.series.entity.Series;
import com.cp1.series.entity.Temporadas;
import com.cp1.series.repository.SeriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeriesService {
    private final SeriesRepository seriesRepository;
    private final TemporadasService temporadasService;
    private final CapitulosService capitulosService;
    @Value("${queue.serie}")
    private String queue;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public List<DTOSeries> findAll() {
        List<Series> series = seriesRepository.findAll();
        List<DTOSeries> seriesDto = new ArrayList<>();

        for(Series serie : series){
            List<Temporadas> temporadas = temporadasService.findBySerie(serie.getId());
            List<DTOTemporadas> temporadaDto = new ArrayList<>();
            for(Temporadas temporada : temporadas){
                List<Capitulos> capitulos = capitulosService.findByTemporada(temporada.getId());
                List<DTOCapitulos> capituloDto = new ArrayList<>();
                for(Capitulos capitulo : capitulos) {
                    capituloDto.add(new DTOCapitulos(capitulo.getId(), capitulo.getName(), capitulo.getNumero(), capitulo.getUrlStream()));
                }

                temporadaDto.add(new DTOTemporadas(temporada.getId(), temporada.getNumero(), capituloDto));
                System.out.println(temporadaDto);
            }

            seriesDto.add(new DTOSeries(serie.getId(), serie.getName(), serie.getGenero(), temporadaDto));
            System.out.println(seriesDto);
        }

        return seriesDto;
    }

    public List<DTOSeries> findByGenero(String genero){
        List<Series> series = seriesRepository.findByGenero(genero);

        List<DTOSeries> seriesDto = new ArrayList<>();

        for(Series serie : series){
            List<Temporadas> temporadas = temporadasService.findBySerie(serie.getId());
            List<DTOTemporadas> temporadaDto = new ArrayList<>();
            for(Temporadas temporada : temporadas){
                List<Capitulos> capitulos = capitulosService.findByTemporada(temporada.getId());
                List<DTOCapitulos> capituloDto = new ArrayList<>();
                for(Capitulos capitulo : capitulos) {
                    capituloDto.add(new DTOCapitulos(capitulo.getId(), capitulo.getName(), capitulo.getNumero(), capitulo.getUrlStream()));
                }

                temporadaDto.add(new DTOTemporadas(temporada.getId(), temporada.getNumero(), capituloDto));
                System.out.println(temporadaDto);
            }

            seriesDto.add(new DTOSeries(serie.getId(), serie.getName(), serie.getGenero(), temporadaDto));
            System.out.println(seriesDto);
        }

        return seriesDto;
    }

    public Optional<Series> findById(Long id) {
        Optional<Series> filmes;

        filmes = seriesRepository.findById(id);
        if(filmes.isPresent()){
            return filmes;
        } else {
            return Optional.of(null);
        }
    }

    public Optional<Series> addSerie(Series serie) {
        if (serie == null) {
            return Optional.of(null);
        } else {
            Series newSeries = seriesRepository.saveAndFlush(
                    new Series(
                            null,
                            serie.getName(),
                            serie.getGenero()
                    )
            );
            rabbitTemplate.convertAndSend(queue, newSeries);
            return Optional.of(newSeries);
        }
    }

    public Optional<Series> updateSerie (Series series) {
        if (series == null) {
            return Optional.of(null);
        } else {
            Series seriesUpdate = new Series(
                    series.getId(),
                    series.getName(),
                    series.getGenero()
            );
            return Optional.of(seriesRepository.saveAndFlush(seriesUpdate));
        }
    }

    public Boolean hardDeleteSerie(Long id) {
        if(seriesRepository.findById(id).isPresent()){
            seriesRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
