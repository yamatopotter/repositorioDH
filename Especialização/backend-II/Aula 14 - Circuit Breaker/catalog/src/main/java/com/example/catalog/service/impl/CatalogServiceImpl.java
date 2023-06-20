package com.example.catalog.service.impl;

import com.example.catalog.service.CatalogService;
import com.example.catalog.service.MovieClient;
import com.example.catalog.service.dto.CatalogDTO;
import com.example.catalog.service.dto.MovieDTO;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private MovieClient movieClient;

    @Override
    @CircuitBreaker(name="movie-service", fallbackMethod="getMovieFallback")
    public CatalogDTO getCatalogByGenre(String genre) {
        var dto = new CatalogDTO();
        dto.setGenre(genre);
        dto.setMovies(movieClient.getMoviesByGenre(genre));
        return dto;
    }

    public CatalogDTO getMovieFallback(String genre, CallNotPermittedException e) {
        var catalog = new CatalogDTO();
        catalog.setGenre(genre);
        var movieDTO = new MovieDTO();
        movieDTO.setName("O serviço de filmes está fora do ar.");
        catalog.setMovies(Arrays.asList(movieDTO));
        return catalog;
    }
}
