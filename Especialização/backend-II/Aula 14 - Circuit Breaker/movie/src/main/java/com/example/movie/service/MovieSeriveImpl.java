package com.example.movie.service;

import com.example.movie.entity.Movie;
import com.example.movie.repository.MoviRepository;
import com.example.movie.service.dto.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class MovieSeriveImpl implements MovieService {

    @Autowired
    private MoviRepository repository;

    @Override
    @Transactional
    public MovieDTO save(MovieDTO dto) {
        var movie = new Movie();
        movie.setName(dto.getName());
        movie.setGenre(dto.getGenre());
        movie.setUrlStream(dto.getUrlStream());
        movie = repository.save(movie);
        return new MovieDTO(movie);
    }

    @Override
    public List<MovieDTO> getMovieByGenre(String genre) {
        var movies = repository.findByGenre(genre);
        return movies.stream().map(MovieDTO::new).collect(Collectors.toList());
    }
}
