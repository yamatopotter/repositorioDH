package com.cp1.catalogo.service;

import com.cp1.catalogo.entity.Series;
import com.cp1.catalogo.repository.SeriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeriesService {
    private final SeriesRepository seriesRepository;

    public List<Series> findAll() {
        List<Series> series;
        return series = seriesRepository.findAll();
    }

    public List<Series> findByGenero(String genero) {
        List<Series> series;
        series = seriesRepository.findByGenero(genero);
        if (series != null){
            return series;
        } else {
            return null;
        }
    }

    public Optional<Series> findById(Long id) {
        Optional<Series> serie;

        serie = seriesRepository.findById(id);
        if(serie.isPresent()){
            return serie;
        } else {
            return Optional.empty();
        }
    }

    public Optional<Series> addSerie(Series serie) {
        if (serie == null) {
            return Optional.of(null);
        } else {
            if(serie.getId()==null){
                Series newSeries = seriesRepository.saveAndFlush(
                        new Series(
                                null,
                                serie.getName(),
                                serie.getGenero()
                        )
                );
                return Optional.of(newSeries);
            }

            Series newSeries = seriesRepository.saveAndFlush(
                    new Series(
                            serie.getId(),
                            serie.getName(),
                            serie.getGenero()
                    )
            );
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
