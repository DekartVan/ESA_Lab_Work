package com.ssau.lab4.service;

import com.ssau.lab4.jms.Producer;
import com.ssau.lab4.models.EventType;
import com.ssau.lab4.models.Movie;
import com.ssau.lab4.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final Producer producer;

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(Producer producer, MovieRepository movieRepository) {
        this.producer = producer;
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    public Movie getById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    public void deleteById(Long id) {
        producer.sendMessage(movieRepository.findOneByUniqueId(id), EventType.delete);
        movieRepository.deleteById(id);
    }
}
