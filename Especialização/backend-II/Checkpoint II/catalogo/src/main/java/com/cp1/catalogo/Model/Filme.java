package com.cp1.catalogo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Filme {
    Long id;
    String name;
    String genero;
    String urlStream;
}