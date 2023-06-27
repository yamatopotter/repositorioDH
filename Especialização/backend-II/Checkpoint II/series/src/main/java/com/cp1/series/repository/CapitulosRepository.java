package com.cp1.series.repository;

import com.cp1.series.entity.Capitulos;
import com.cp1.series.entity.Series;
import com.cp1.series.entity.Temporadas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CapitulosRepository extends JpaRepository<Capitulos, Long> {
    List<Capitulos> findByTemporada(Temporadas temporada);
}
