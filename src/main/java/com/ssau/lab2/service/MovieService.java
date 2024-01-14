package com.ssau.lab2.service;

import com.ssau.lab2.models.Movie;
import com.ssau.lab2.repository.MovieRepository;
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

    public Movie getById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }

    public void delete(Movie movie) {
        movieRepository.delete(movie);
    }

    public void deleteAll() {
        movieRepository.deleteAll();
    }

    public boolean existsById(Long id) {
        return movieRepository.existsById(id);
    }

    public long count() {
        return movieRepository.count();
    }

    public List<Movie> saveAll(List<Movie> movies) {
        return movieRepository.saveAll(movies);
    }

    public List<Movie> findAllById(List<Long> ids) {
        return movieRepository.findAllById(ids);
    }

    public void deleteAll(List<Movie> movies) {
        movieRepository.deleteAll(movies);
    }
}
