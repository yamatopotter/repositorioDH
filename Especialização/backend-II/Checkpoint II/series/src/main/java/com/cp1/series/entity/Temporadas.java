package com.cp1.series.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Temporadas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Series serie;
    Integer numero;
}
