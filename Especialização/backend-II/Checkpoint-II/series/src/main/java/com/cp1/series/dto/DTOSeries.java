package com.cp1.series.dto;

import com.cp1.series.entity.Series;
import com.cp1.series.entity.Temporadas;
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
