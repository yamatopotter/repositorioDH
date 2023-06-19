package com.example.movie.resource;

import com.example.movie.service.MovieService;
import com.example.movie.service.dto.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Autowired
    private MovieService service;

    @PostMapping
    public ResponseEntity<MovieDTO> saveMovie(@RequestBody MovieDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @GetMapping("/{genre}")
    public ResponseEntity<List<MovieDTO>> getMovieByGenre(@PathVariable String genre){
        return ResponseEntity.ok(service.getMovieByGenre(genre));
    }

    @GetMapping
    public ResponseEntity<String> getToTest(){
        return ResponseEntity.ok("service.getMovieByGenre(genre)");
    }
}
