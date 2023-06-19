package com.example.movie.service;

import com.example.movie.service.dto.MovieDTO;

import java.util.List;

public interface MovieService {
    MovieDTO save(MovieDTO dto);
    List<MovieDTO> getMovieByGenre(String genre);
}
