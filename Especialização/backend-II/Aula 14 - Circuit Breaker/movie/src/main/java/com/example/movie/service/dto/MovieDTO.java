package com.example.movie.service.dto;

import com.example.movie.entity.Movie;
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

    public MovieDTO(Movie entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.genre = entity.getGenre();
        this.urlStream = entity.getUrlStream();
    }
}
