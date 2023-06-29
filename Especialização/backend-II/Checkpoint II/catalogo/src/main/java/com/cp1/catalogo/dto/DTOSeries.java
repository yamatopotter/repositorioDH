package com.cp1.catalogo.dto;

import com.cp1.catalogo.entity.Series;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOSeries {
    Long id;
    String name;
    String genero;
    List<DTOTemporadas> temporadas;
}
