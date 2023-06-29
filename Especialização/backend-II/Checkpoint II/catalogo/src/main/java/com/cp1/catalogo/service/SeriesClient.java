package com.cp1.catalogo.service;

import com.cp1.catalogo.dto.DTOSeries;
import com.cp1.catalogo.entity.Filme;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("SERIES-SERVICE")
@LoadBalancerClient(value="SERIES-SERVICE")
public interface SeriesClient {

        @GetMapping("/series/{genero}")
        List<DTOSeries> findByGenero(@PathVariable String genero);

        @GetMapping("/series")
        List<DTOSeries>findAll();
}
