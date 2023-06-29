package com.cp1.filmes.config;

import javax.annotation.PostConstruct;

import com.cp1.filmes.entity.Filme;
import com.cp1.filmes.repository.FilmeRepository;
import com.cp1.filmes.service.FilmeService;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final FilmeService filmeService;

    public DataInitializer(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @PostConstruct
    public void init() {
        filmeService.addFilme(new Filme(null, "Filme 1", "Ação", "https://urlStrem.filme1.com"));
        filmeService.addFilme(new Filme(null, "Filme 2", "Drama", "https://urlStrem.filme3.com"));
        filmeService.addFilme(new Filme(null, "Filme 3", "Comédia", "https://urlStrem.filme5.com"));
    }
}