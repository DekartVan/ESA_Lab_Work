package com.ssau.lab2.controller;

import com.ssau.lab2.models.Director;
import com.ssau.lab2.models.Movie;
import com.ssau.lab2.repository.DirectorRepository;
import com.ssau.lab2.repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MovieController {

    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;

    @Autowired
    public MovieController(MovieRepository movieRepository, DirectorRepository directorRepository) {
        this.movieRepository = movieRepository;
        this.directorRepository = directorRepository;
    }

    @GetMapping("/movies")
    public String getAll(Model model) {
        List<Movie> movies = movieRepository.findAll();
        model.addAttribute("movies", movies);
        return "movies";
    }

    @GetMapping("/movies/{id}")
    public String getById(@PathVariable Long id, Model model) {
        Movie movie = movieRepository.findById(id).orElse(null);
        model.addAttribute("movie", movie);
        return "movie";
    }

    @GetMapping("/movies/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Movie movie = movieRepository.findById(id).orElse(null);
        model.addAttribute("directors", directorRepository.findAll());
        model.addAttribute("movie", movie);
        return "movie-edit";
    }

    @PostMapping("/movies/{id}/edit")
    public String edit(@PathVariable Long id, Movie movie) {
        movieRepository.save(movie);
        return "redirect:/movies";
    }

    @GetMapping("/movies/{id}/delete")
    public String delete(@PathVariable Long id) {
        movieRepository.deleteById(id);
        return "redirect:/movies";
    }

    @GetMapping("/movies/add")
    public String add(Model model) {
        List<Director> directors = directorRepository.findAll();
        model.addAttribute("directors", directors);
        model.addAttribute("movie", new Movie());
        return "movie-add";
    }

    @PostMapping("/movies/add")
    public String add(Movie movie) {
        movieRepository.save(movie);
        return "redirect:/movies";
    }
}
