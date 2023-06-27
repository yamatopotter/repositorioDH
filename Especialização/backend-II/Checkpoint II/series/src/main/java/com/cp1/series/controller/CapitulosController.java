package com.cp1.series.controller;

import com.cp1.series.entity.Capitulos;
import com.cp1.series.entity.Series;
import com.cp1.series.service.CapitulosService;
import com.cp1.series.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/capitulos")
public class CapitulosController {
    @Autowired
    private CapitulosService capitulosService;

    @GetMapping
    public ResponseEntity<List<Capitulos>> findAll() {
        try {
            List<Capitulos> list = capitulosService.findAll();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/detalhes/{id}")
    public ResponseEntity<Optional<Capitulos>> findById(@PathVariable Long id) {
        try {
            Optional<Capitulos> capitulos = capitulosService.findById(id);
            if (capitulos.isPresent()) return ResponseEntity.ok(capitulos);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return null;
    }

    @PostMapping
    public ResponseEntity addCapitulo (@RequestBody Capitulos capitulos) {
        try {
            if (capitulos != null) {
                Optional<Capitulos> newCapitulo = capitulosService.addCapitulo(capitulos);
                if (newCapitulo.isPresent()) return new ResponseEntity<>(newCapitulo, HttpStatus.CREATED);
            }
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return null;
    }

    @PutMapping
    public ResponseEntity<Optional<Capitulos>> updateCapitulos (@RequestBody Capitulos capitulos) {
        try {
            if (capitulos != null) {
                Optional<Capitulos> updateCapitulo = capitulosService.updateCapitulo(capitulos);
                if (updateCapitulo.isPresent()) return ResponseEntity.ok(updateCapitulo);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Capitulos>> hardDeleteCapitulos (@PathVariable Long id) {
        try {
            if (capitulosService.findById(id).isPresent() && capitulosService.hardDeleteCapitulo(id)){
                return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return null;
    }
}
