package com.ssau.lab3.controller;
import com.ssau.lab3.service.MovieService;
import com.ssau.lab3.models.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
@RequiredArgsConstructor
public class MovieRestController {
    private final MovieService movieService;

    @GetMapping(path = "/all", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Movie> getAll() {
        return movieService.getAll();
    }

    @PostMapping(path = "/save", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void save(@RequestBody Movie movie) {
        movieService.save(movie);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable Long id) {
        movieService.deleteById(id);
    }
}
