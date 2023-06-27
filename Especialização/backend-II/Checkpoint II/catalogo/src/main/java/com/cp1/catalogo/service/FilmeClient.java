package com.cp1.catalogo.service;

import com.cp1.catalogo.Model.Filme;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("FILME-SERVICE")
@LoadBalancerClient(value="FILME-SERVICE")
public interface FilmeClient {
    @GetMapping("/filme/{genero}")
    List<Filme>findByGenero(@PathVariable String genero);

    @GetMapping("/filme")
    List<Filme>findAll();
}
