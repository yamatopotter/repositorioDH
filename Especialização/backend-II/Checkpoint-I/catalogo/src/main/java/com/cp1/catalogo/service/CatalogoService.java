package com.cp1.catalogo.service;

import com.cp1.filmes.entity.Filme;

import java.util.List;

public interface CatalogoService {
    List<Filme> getFilmeByGenero(String genero);

    List<Filme> getAllFilmes();
}
