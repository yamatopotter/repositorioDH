package com.cp1.catalogo.service.impl;

import com.cp1.catalogo.dto.DTOSeries;
import com.cp1.catalogo.entity.Filme;
import com.cp1.catalogo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CatalogoServiceImpl implements CatalogoService {
    @Autowired
    private FilmeClient filmeClient;
    @Autowired
    private FilmeService filmeService;
    @Autowired
    private SeriesClient seriesClient;
    @Autowired
    private SeriesService seriesService;


    //    Pega lista de generos de filme direto da API
    @Override
    @CircuitBreaker(name="movie-service", fallbackMethod="getFilmeByGeneroFallback")
    public List<Filme> getFilmeByGenero(String genero) {
        List<Filme> filme;
        filme = filmeClient.findByGenero(genero);
        return filme;
    }

    public List<Filme> getFilmeByGeneroFallback(String genero, CallNotPermittedException e) {
        System.out.println(e);
        List<Filme> filme;
        filme = filmeService.findByGenero(genero);
        return filme;
    }

    // Pega todos os filmes direto da API
    @Override
    @CircuitBreaker(name="movie-service", fallbackMethod="getAllFilmesFallback")
    public List<Filme> getAllFilmes() {
        List<Filme> filme;
        return filme = filmeClient.findAll();
    }

    public List<Filme> getAllFilmesFallback(CallNotPermittedException e) {
        System.out.println(e);
        List<Filme> filme;
        return filme = filmeService.findAll();
    }

    // Pega todas séries direto da API
    @Override
    @CircuitBreaker(name="serie-service", fallbackMethod="getAllSeriesFallback")
    public List<DTOSeries> getAllSeries() {
        List<DTOSeries> series;
        return series = seriesClient.findAll();
    }

    public List<DTOSeries> getAllSeriesFallback(CallNotPermittedException e){
        System.out.println(e);
        List<DTOSeries> series = seriesService.findAll();
        return series;
    }


    // Pega todas series de x genero direto da API
    @Override
    @CircuitBreaker(name="serie-service", fallbackMethod="getSeriesByGeneroFallback")
    public List<DTOSeries> getSeriesByGenero(String genero) {
        List<DTOSeries> series;
        return series = seriesClient.findByGenero(genero);
    }

    // Pega os dados do banco local
    public List<DTOSeries> getSeriesByGeneroFallback(String genero, CallNotPermittedException e){
        System.out.println(e);
        List<DTOSeries> series = seriesService.findByGenero(genero);
        return series;
    }
}
