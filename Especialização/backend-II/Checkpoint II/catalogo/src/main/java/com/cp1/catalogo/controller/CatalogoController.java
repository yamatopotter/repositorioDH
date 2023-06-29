package com.cp1.catalogo.controller;

import com.cp1.catalogo.dto.DTOCapitulos;
import com.cp1.catalogo.dto.DTOSeries;
import com.cp1.catalogo.dto.DTOTemporadas;
import com.cp1.catalogo.entity.Capitulos;
import com.cp1.catalogo.entity.Filme;
import com.cp1.catalogo.entity.Series;
import com.cp1.catalogo.entity.Temporadas;
import com.cp1.catalogo.service.*;
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
    @Autowired
    private TemporadasService temporadasService;
    @Autowired
    private CapitulosService capitulosService;

    @GetMapping
    private ResponseEntity<String> work(){
        return ResponseEntity.ok("It Works!");
    }

    @GetMapping("/filmes")
    public ResponseEntity<List<Filme>> getFilmes(){
        List<Filme> filmes = filmeService.findAll();
        return ResponseEntity.ok(filmes);
    }

    @GetMapping("/series")
    public ResponseEntity<List<DTOSeries>> getSeries(){
        List<Series> series = seriesService.findAll();

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


        return ResponseEntity.ok(seriesDto);
    }

    @GetMapping("/filmes/{genero}")
    public ResponseEntity<List<Filme>> getFilmesByGenero(@PathVariable String genero){
        List<Filme> filmes = catalogoService.getFilmeByGenero(genero);
        return ResponseEntity.ok(filmes);
    }

    @GetMapping("/series/{genero}")
    public ResponseEntity<List<DTOSeries>> getSeriesByGenero(@PathVariable String genero){
        List<Series> series = seriesService.findByGenero(genero);

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


        return ResponseEntity.ok(seriesDto);
    }
    @GetMapping("/todos")
    public ResponseEntity<List<Filme>> getAllFilmes(){
        List<Filme> filmes = catalogoService.getAllFilmes();
        return  ResponseEntity.ok(filmes);
    }
}
