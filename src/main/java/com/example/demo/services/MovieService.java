package com.example.demo.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import com.example.demo.repositories.MovieRepository;
import com.example.demo.models.Movie;
import java.util.List;

@Stateless
public class MovieService {

    @Inject
    private MovieRepository movieRepository;

    public MovieService() {
    }

    public Movie findById(Long id) {
        return movieRepository.findById(id);
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public void create(Movie movie) {
        movieRepository.create(movie);
    }

    public void update(Movie movie) {
        movieRepository.update(movie);
    }

    public void delete(Movie movie) {
        movieRepository.delete(movie);
    }

    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }
}
