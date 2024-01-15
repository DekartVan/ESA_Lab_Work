package com.ssau.lab4.controller;

import com.ssau.lab4.models.Director;
import com.ssau.lab4.models.Movie;
import com.ssau.lab4.repository.DirectorRepository;
import com.ssau.lab4.repository.MovieRepository;
import com.ssau.lab4.service.DirectorService;
import com.ssau.lab4.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MovieController {

    private final MovieService movieService;
    private final DirectorService directorService;

    @Autowired
    public MovieController(MovieService movieService, DirectorService directorService) {
        this.movieService = movieService;
        this.directorService = directorService;
    }

    @GetMapping("/movies")
    public String getAll(Model model) {
        List<Movie> movies = movieService.getAll();
        model.addAttribute("movies", movies);
        return "movies";
    }

    @GetMapping("/movies/{id}")
    public String getById(@PathVariable Long id, Model model) {
        Movie movie = movieService.getById(id);
        model.addAttribute("movie", movie);
        return "movie";
    }

    @GetMapping("/movies/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Movie movie = movieService.getById(id);
        model.addAttribute("directors", directorService.getAll());
        model.addAttribute("movie", movie);
        return "movie-edit";
    }

    @PostMapping("/movies/{id}/edit")
    public String edit(@PathVariable Long id, Movie movie) {
        movieService.save(movie);
        return "redirect:/movies";
    }

    @GetMapping("/movies/{id}/delete")
    public String delete(@PathVariable Long id) {
        movieService.deleteById(id);
        return "redirect:/movies";
    }

    @GetMapping("/movies/add")
    public String add(Model model) {
        List<Director> directors = directorService.getAll();
        model.addAttribute("directors", directors);
        model.addAttribute("movie", new Movie());
        return "movie-add";
    }

    @PostMapping("/movies/add")
    public String add(Movie movie) {
        movieService.save(movie);
        return "redirect:/movies";
    }
}
