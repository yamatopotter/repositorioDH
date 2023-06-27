package com.cp1.catalogo.service.impl;

import com.cp1.catalogo.Entity.Filme;
import com.cp1.catalogo.service.CatalogoService;
import com.cp1.catalogo.service.FilmeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogoServiceImpl implements CatalogoService {
    @Autowired
    private FilmeClient filmeClient;

    @Override
    public List<Filme> getFilmeByGenero(String genero) {
        List<Filme> filme;
        filme = filmeClient.findByGenero(genero);
        return filme;
    }

    @Override
    public List<Filme> getAllFilmes() {
        List<Filme> filme;
        return filme = filmeClient.findAll();
    }
}
