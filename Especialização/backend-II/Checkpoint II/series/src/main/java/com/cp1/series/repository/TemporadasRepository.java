package com.cp1.series.repository;

import com.cp1.series.entity.Series;
import com.cp1.series.entity.Temporadas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TemporadasRepository extends JpaRepository<Temporadas, Long> {
    List<Temporadas> findBySerie(Optional<Series> series);

}
