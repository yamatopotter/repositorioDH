package com.example.catalog.service.impl;

import com.example.catalog.service.dto.MovieDTO;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("MOVIE-SERVICE")
@LoadBalancerClient("MOVIE-SERVICE")
public interface MovieClient {

    @GetMapping("/movie-api/movies/{genre}")
    List<MovieDTO> getMoviesByGenre(@PathVariable String genre);
}
