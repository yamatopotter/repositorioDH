package com.cp1.series.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Capitulos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Temporadas temporada;
    String name;
    Integer numero;
    String urlStream;
}
