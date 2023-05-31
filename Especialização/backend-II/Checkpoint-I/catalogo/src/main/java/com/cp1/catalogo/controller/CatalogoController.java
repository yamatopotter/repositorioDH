package com.cp1.catalogo.controller;

import com.cp1.catalogo.service.CatalogoService;
import com.cp1.filmes.entity.Filme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalogo")
public class CatalogoController {
    @Autowired
    private CatalogoService catalogoService;

    @GetMapping
    private ResponseEntity<String> work(){
        return ResponseEntity.ok("It Works!");
    }

    @GetMapping("/{genero}")
    public ResponseEntity<List<Filme>> getFilmesByGenero(@PathVariable String genero){
        List<Filme> filmes = catalogoService.getFilmeByGenero(genero);
        return ResponseEntity.ok(filmes);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Filme>> getAllFilmes(){
        List<Filme> filmes = catalogoService.getAllFilmes();
        return  ResponseEntity.ok(filmes);
    }
}
