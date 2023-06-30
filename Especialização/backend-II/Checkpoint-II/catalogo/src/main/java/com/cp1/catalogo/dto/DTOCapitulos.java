package com.cp1.catalogo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOCapitulos {
    Long id;
    String name;
    Integer numero;
    String urlStream;
}
