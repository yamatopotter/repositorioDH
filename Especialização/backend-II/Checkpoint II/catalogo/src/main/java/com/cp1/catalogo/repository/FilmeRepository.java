package com.cp1.catalogo.repository;

import com.cp1.filmes.entity.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
    List<Filme> findByGenero(String genero);
    Optional<Filme> findByName(String name);
}
