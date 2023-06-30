package com.cp1.catalogo.controller;

import com.cp1.catalogo.dto.DTOCapitulos;
import com.cp1.catalogo.dto.DTOSeries;
import com.cp1.catalogo.dto.DTOTemporadas;
import com.cp1.catalogo.entity.Capitulos;
import com.cp1.catalogo.entity.Filme;
import com.cp1.catalogo.entity.Series;
import com.cp1.catalogo.entity.Temporadas;
import com.cp1.catalogo.service.*;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/catalogo")
public class CatalogoController {
    @Autowired
    private CatalogoService catalogoService;
    @Autowired
    private FilmeService filmeService;
    @Autowired
    private SeriesService seriesService;

    @GetMapping
    private ResponseEntity<String> work(){
        return ResponseEntity.ok("It Works!");
    }

    @GetMapping("/filmes/{genero}")
    public ResponseEntity<List<Filme>> getFilmesByGenero(@PathVariable String genero){
        List<Filme> filmes = catalogoService.getFilmeByGenero(genero);
        return ResponseEntity.ok(filmes);
    }

    @GetMapping("/local/filmes")
    public ResponseEntity<List<Filme>> getAllLocalFilmes(){
        List<Filme> filmes = filmeService.findAll();
        return  ResponseEntity.ok(filmes);
    }

    @GetMapping("/local/series")
    public ResponseEntity<List<DTOSeries>> getAllLocalSeries(){
        List<DTOSeries> series = seriesService.findAll();
        return  ResponseEntity.ok(series);
    }

    @GetMapping("/series/{genero}")
    public ResponseEntity<List<DTOSeries>> getSeriesByGenero(@PathVariable String genero){
        List<DTOSeries> series = catalogoService.getSeriesByGenero(genero);
        return ResponseEntity.ok(series);
    }

    @GetMapping("/filmes")
    public ResponseEntity<List<Filme>> getAllFilmes(){
        List<Filme> filmes = catalogoService.getAllFilmes();
        return  ResponseEntity.ok(filmes);
    }

    @GetMapping("/series")
    public ResponseEntity<List<DTOSeries>> getAllSeries(){
        List<DTOSeries> series = catalogoService.getAllSeries();
        return  ResponseEntity.ok(series);
    }
}
