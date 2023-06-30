package com.cp1.catalogo.service;

import com.cp1.catalogo.dto.DTOCapitulos;
import com.cp1.catalogo.dto.DTOSeries;
import com.cp1.catalogo.dto.DTOTemporadas;
import com.cp1.catalogo.entity.Capitulos;
import com.cp1.catalogo.entity.Series;
import com.cp1.catalogo.entity.Temporadas;
import com.cp1.catalogo.repository.CapitulosRepository;
import com.cp1.catalogo.repository.SeriesRepository;
import com.cp1.catalogo.repository.TemporadasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeriesService {
    private final SeriesRepository seriesRepository;
    private final TemporadasService temporadasService;
    private final CapitulosService capitulosService;

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

//    public List<Series> findByGenero(String genero) {
//        List<Series> series;
//        series = seriesRepository.findByGenero(genero);
//        if (series != null){
//            return series;
//        } else {
//            return null;
//        }
//    }

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
