package com.example.movie.repository;

import com.example.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoviRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByGenre(String genre);
}
