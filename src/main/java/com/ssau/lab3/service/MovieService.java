package com.ssau.lab3.service;

import com.ssau.lab3.models.Movie;
import com.ssau.lab3.repository.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    @Transactional
    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    @Transactional
    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }
}
