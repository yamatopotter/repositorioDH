package com.example.catalog.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
    private Long id;
    private String name;
    private String genre;
    private String urlStream;

}
