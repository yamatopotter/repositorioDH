package com.cp1.series.controller;

import com.cp1.series.entity.Temporadas;
import com.cp1.series.service.TemporadasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/temporadas")
public class TemporadasController {
    @Autowired
    private TemporadasService temporadasService;

    @GetMapping
    public ResponseEntity<List<Temporadas>> findAll() {
        try {
            List<Temporadas> list = temporadasService.findAll();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/serie/{id}")
    public ResponseEntity<List<Temporadas>> findBySerie(@PathVariable Long id) {
        try {
            List<Temporadas> list = temporadasService.findBySerie(id);
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/detalhes/{id}")
    public ResponseEntity<Optional<Temporadas>> findById(@PathVariable Long id) {
        try {
            Optional<Temporadas> temporadas = temporadasService.findById(id);
            if (temporadas.isPresent()) return ResponseEntity.ok(temporadas);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return null;
    }

    @PostMapping
    public ResponseEntity addTemporada (@RequestBody Temporadas temporadas) {
        try {
            if (temporadas != null) {
                Optional<Temporadas> newTemporada = temporadasService.addTemporada(temporadas);
                if (newTemporada.isPresent()) return new ResponseEntity<>(newTemporada, HttpStatus.CREATED);
            }
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return null;
    }

    @PutMapping
    public ResponseEntity<Optional<Temporadas>> updateTemporadas (@RequestBody Temporadas temporadas) {
        try {
            if (temporadas != null) {
                Optional<Temporadas> updateTemporada = temporadasService.updateTemporada(temporadas);
                if (updateTemporada.isPresent()) return ResponseEntity.ok(updateTemporada);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Temporadas>> hardDeleteTemporadas (@PathVariable Long id) {
        try {
            if (temporadasService.findById(id).isPresent() && temporadasService.hardDeleteTemporadas(id)){
                return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return null;
    }
}
