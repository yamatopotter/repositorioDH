package com.cp1.catalogo.service;

import com.cp1.catalogo.dto.DTOSeries;
import com.cp1.catalogo.entity.Filme;

import java.util.List;

public interface CatalogoService {
    List<Filme> getFilmeByGenero(String genero);
    List<Filme> getAllFilmes();

    List<DTOSeries> getAllSeries();
}
