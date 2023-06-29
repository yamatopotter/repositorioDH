package com.cp1.catalogo.repository;

import com.cp1.catalogo.entity.Series;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SeriesRepository extends JpaRepository<Series, Long> {
    List<Series> findByGenero(String genero);
    Optional<Series> findByName(String name);
}
