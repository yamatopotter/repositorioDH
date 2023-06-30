package com.cp1.series.service;

import com.cp1.series.entity.Series;
import com.cp1.series.entity.Temporadas;
import com.cp1.series.repository.SeriesRepository;
import com.cp1.series.repository.TemporadasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TemporadasService {
    private final TemporadasRepository temporadasRepository;
    private final SeriesRepository seriesRepository;
    @Value("${queue.temporada}")
    private String queue;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public List<Temporadas> findAll() {
        List<Temporadas> temporadas;
        return temporadas = temporadasRepository.findAll();
    }

    public List<Temporadas> findBySerie(Long id) {
        List<Temporadas> temporadas;
        Optional<Series> serie = seriesRepository.findById(id);
        return temporadas = temporadasRepository.findBySerie(serie);
    }
    public Optional<Temporadas> findById(Long id) {
        Optional<Temporadas> temporadas;

        temporadas = temporadasRepository.findById(id);
        if(temporadas.isPresent()){
            return temporadas;
        } else {
            return Optional.of(null);
        }
    }



    public Optional<Temporadas> addTemporada(Temporadas temporadas) {
        if (temporadas == null) {
            return Optional.of(null);
        } else {
            Temporadas newTemporadas = temporadasRepository.saveAndFlush(
                    new Temporadas(
                            null,
                            temporadas.getSerie(),
                            temporadas.getNumero()
                    )
            );
            rabbitTemplate.convertAndSend(queue, newTemporadas);
            return Optional.of(newTemporadas);
        }
    }

    public Optional<Temporadas> updateTemporada (Temporadas temporadas) {
        if (temporadas == null) {
            return Optional.of(null);
        } else {
            Temporadas temporadaUpdate = new Temporadas(
                    temporadas.getId(),
                    temporadas.getSerie(),
                    temporadas.getNumero()
            );
            return Optional.of(temporadasRepository.saveAndFlush(temporadaUpdate));
        }
    }

    public Boolean hardDeleteTemporadas(Long id) {
        if(temporadasRepository.findById(id).isPresent()){
            temporadasRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
