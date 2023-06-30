package com.cp1.series.dto;

import com.cp1.series.entity.Capitulos;
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
