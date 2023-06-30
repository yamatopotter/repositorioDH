package com.cp1.catalogo.service;

import com.cp1.catalogo.entity.Capitulos;
import com.cp1.catalogo.entity.Series;
import com.cp1.catalogo.entity.Temporadas;
import com.cp1.catalogo.repository.CapitulosRepository;
import com.cp1.catalogo.repository.SeriesRepository;
import com.cp1.catalogo.repository.TemporadasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CapitulosService {
    private final CapitulosRepository capitulosRepository;
    private final TemporadasRepository temporadasRepository;
    private final SeriesRepository seriesRepository;

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

    public List<Capitulos> findByTemporada(Long id) {
        List<Capitulos> capitulos;
        Optional<Temporadas> temporada = temporadasRepository.findById(id);
        return capitulos = capitulosRepository.findByTemporada(temporada.get());
    }

    public Optional<Capitulos> addCapitulo(Capitulos capitulo) {
        if (capitulo == null) {
            return Optional.of(null);
        } else {
            if(capitulo.getId()==null){
                Capitulos newCapitulo = capitulosRepository.saveAndFlush(
                        new Capitulos(
                                null,
                                capitulo.getTemporada(),
                                capitulo.getName(),
                                capitulo.getNumero(),
                                capitulo.getUrlStream()
                        )
                );
                return Optional.of(newCapitulo);
            }
            Capitulos newCapitulo = capitulosRepository.saveAndFlush(
                    new Capitulos(
                            capitulo.getId(),
                            capitulo.getTemporada(),
                            capitulo.getName(),
                            capitulo.getNumero(),
                            capitulo.getUrlStream()
                    )
            );
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
