package com.cp1.filmes.controller;

import com.cp1.filmes.entity.Filme;
import com.cp1.filmes.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filme")
public class FilmeController {
    @Autowired
    private FilmeService filmeService;

    @GetMapping
    public ResponseEntity<List<Filme>> findAll() {
        try {
            List<Filme> list = filmeService.findAll();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/detalhes/{id}")
    public ResponseEntity<Optional<Filme>> findById(@PathVariable Long id) {
        try {
            Optional<Filme> filme = filmeService.findById(id);
            if (filme.isPresent()) return ResponseEntity.ok(filme);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return null;
    }

    @GetMapping("/{genero}")
    public ResponseEntity<List<Filme>> findByGenero(@PathVariable String genero){
        try {
            List<Filme> list = filmeService.findByGenero(genero);
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity addFilme (@RequestBody Filme filme) {
        try {
            if (filme != null) {
                Optional<Filme> newFilme = filmeService.addFilme(filme);
                if (newFilme.isPresent()) return new ResponseEntity<>(newFilme, HttpStatus.CREATED);
            }
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return null;
    }

    @PutMapping
    public ResponseEntity<Optional<Filme>> updateFilme (@RequestBody Filme filme) {
        try {
            if (filme != null) {
                Optional<Filme> updateFilme = filmeService.updateFilme(filme);
                if (updateFilme.isPresent()) return ResponseEntity.ok(updateFilme);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Filme>> hardDeleteFilme (@PathVariable Long id) {
        try {
            if (filmeService.findById(id).isPresent() && filmeService.hardDeleteFilme(id)) return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return null;
    }
}
