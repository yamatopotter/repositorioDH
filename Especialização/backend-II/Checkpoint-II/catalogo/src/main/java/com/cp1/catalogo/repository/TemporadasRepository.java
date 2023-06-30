package com.cp1.catalogo.repository;

import com.cp1.catalogo.entity.Series;
import com.cp1.catalogo.entity.Temporadas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TemporadasRepository extends JpaRepository<Temporadas, Long> {
    List<Temporadas> findBySerie(Series series);

}
