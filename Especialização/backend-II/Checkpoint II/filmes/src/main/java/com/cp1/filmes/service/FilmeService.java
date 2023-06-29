package com.cp1.filmes.service;

import com.cp1.filmes.entity.Filme;
import com.cp1.filmes.repository.FilmeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FilmeService {
    private final FilmeRepository filmeRepository;

    @Value("${queue.filme}")
    private String queue;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public List<Filme> findAll() {
        List<Filme> filmes;
        return filmes = filmeRepository.findAll();
    }

    public List<Filme> findByGenero(String genero) {
        List<Filme> filmes;
        filmes = filmeRepository.findByGenero(genero);
        if (filmes != null){
            return filmes;
        } else {
            return null;
        }
    }

    public Optional<Filme> findById(Long id) {
        Optional<Filme> filmes;

        filmes = filmeRepository.findById(id);
        if(filmes.isPresent()){
            return filmes;
        } else {
            return Optional.of(null);
        }
    }

    public Optional<Filme> addFilme(Filme filmes) {
        if (filmes == null) {
            return Optional.of(null);
        } else {

            Filme newFilme = filmeRepository.saveAndFlush(
                    new Filme(
                            null,
                            filmes.getName(),
                            filmes.getGenero(),
                            filmes.getUrlStream()
                    )
            );

            rabbitTemplate.convertAndSend(queue, newFilme);
            return Optional.of(newFilme);
        }
    }

    public Optional<Filme> updateFilme (Filme filme) {
        if (filme == null) {
            return Optional.of(null);
        } else {
            Filme filmeUpdate = new Filme (
                    filme.getId(),
                    filme.getName(),
                    filme.getGenero(),
                    filme.getUrlStream()
            );
            return Optional.of(filmeRepository.saveAndFlush(filmeUpdate));
        }
    }

    public Boolean hardDeleteFilme(Long id) {
        if(filmeRepository.findById(id).isPresent()){
            filmeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
