package com.cp1.catalogo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOTemporadas {
    Long id;
    Integer numero;
    List<DTOCapitulos> capitulos;
}
