package com.cp1.catalogo.repository;

import com.cp1.catalogo.entity.Capitulos;
import com.cp1.catalogo.entity.Temporadas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CapitulosRepository extends JpaRepository<Capitulos, Long> {
    List<Capitulos> findByTemporada(Temporadas temporada);
}
