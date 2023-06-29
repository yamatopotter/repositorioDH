package com.cp1.series.service;

import com.cp1.series.entity.Capitulos;
import com.cp1.series.repository.CapitulosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CapitulosService {
    private final CapitulosRepository capitulosRepository;
    @Value("${queue.capitulo}")
    private String queue;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public List<Capitulos> findAll() {
        List<Capitulos> capitulos;
        return capitulos = capitulosRepository.findAll();
    }

    public Optional<Capitulos> findById(Long id) {
        Optional<Capitulos> capitulo;

        capitulo = capitulosRepository.findById(id);
        if(capitulo.isPresent()){
            return capitulo;
        } else {
            return Optional.of(null);
        }
    }

    public Optional<Capitulos> addCapitulo(Capitulos capitulo) {
        if (capitulo == null) {
            return Optional.of(null);
        } else {
            Capitulos newCapitulo = capitulosRepository.saveAndFlush(
                    new Capitulos(
                            null,
                            capitulo.getTemporada(),
                            capitulo.getName(),
                            capitulo.getNumero(),
                            capitulo.getUrlStream()
                    )
            );
            rabbitTemplate.convertAndSend(queue, newCapitulo);
            return Optional.of(newCapitulo);
        }
    }

    public Optional<Capitulos> updateCapitulo (Capitulos capitulo) {
        if (capitulo == null) {
            return Optional.of(null);
        } else {
            Capitulos capituloUpdate = new Capitulos(
                    capitulo.getId(),
                    capitulo.getTemporada(),
                    capitulo.getName(),
                    capitulo.getNumero(),
                    capitulo.getUrlStream()
            );
            return Optional.of(capitulosRepository.saveAndFlush(capituloUpdate));
        }
    }

    public Boolean hardDeleteCapitulo(Long id) {
        if(capitulosRepository.findById(id).isPresent()){
            capitulosRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
