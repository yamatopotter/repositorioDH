package com.cp1.series.controller;

import com.cp1.series.dto.DTOCapitulos;
import com.cp1.series.dto.DTOSeries;
import com.cp1.series.dto.DTOTemporadas;
import com.cp1.series.entity.Capitulos;
import com.cp1.series.entity.Series;
import com.cp1.series.entity.Temporadas;
import com.cp1.series.service.CapitulosService;
import com.cp1.series.service.SeriesService;
import com.cp1.series.service.TemporadasService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/series")
public class SeriesController {
    @Autowired
    private SeriesService seriesService;
    @Autowired
    private TemporadasService temporadasService;
    @Autowired
    private CapitulosService capitulosService;
    @GetMapping
    public ResponseEntity<List<DTOSeries>> findAll() {
        try {
            List<DTOSeries> list = seriesService.findAll();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/detalhes/{id}")
    public ResponseEntity<Optional<Series>> findById(@PathVariable Long id) {
        try {
            Optional<Series> serie = seriesService.findById(id);
            if (serie.isPresent()) return ResponseEntity.ok(serie);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return null;
    }

    @GetMapping("/{genero}")
    public ResponseEntity<List<DTOSeries>> findByGenero(@PathVariable String genero){
        try {
            List<DTOSeries> list = seriesService.findByGenero(genero);
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity addSerie (@RequestBody Series series) {
        try {
            if (series != null) {
                Optional<Series> newSerie = seriesService.addSerie(series);
                if (newSerie.isPresent()) {

                    return new ResponseEntity<>(newSerie, HttpStatus.CREATED);
                }
            }
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return null;
    }

    @PutMapping
    public ResponseEntity<Optional<Series>> updateSerie (@RequestBody Series series) {
        try {
            if (series != null) {
                Optional<Series> updateFilme = seriesService.updateSerie(series);
                if (updateFilme.isPresent()) return ResponseEntity.ok(updateFilme);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Series>> hardDeleteSerie (@PathVariable Long id) {
        try {
            if (seriesService.findById(id).isPresent() && seriesService.hardDeleteSerie(id)){
                return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return null;
    }
}
