package com.cp1.filmes.config;

import javax.annotation.PostConstruct;

import com.cp1.filmes.entity.Filme;
import com.cp1.filmes.repository.FilmeRepository;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final FilmeRepository filmeRepository;

    public DataInitializer(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    @PostConstruct
    public void init() {
        // Inserir dados iniciais no H2
        Filme filme1 = new Filme(null, "Filme 1", "Ação", "https://urlStrem.filme1.com");
        filmeRepository.save(filme1);
        Filme filme2 = new Filme(null, "Filme 2", "Drama", "https://urlStrem.filme3.com");
        filmeRepository.save(filme2);
        Filme filme3 = new Filme(null, "Filme 3", "Comédia", "https://urlStrem.filme5.com");
        filmeRepository.save(filme3);
    }
}