package com.ssau.lab3.controller;

import com.ssau.lab3.ObjectToHTMLElementTransformer;
import com.ssau.lab3.models.Director;
import com.ssau.lab3.models.Movie;
import com.ssau.lab3.service.DirectorService;
import com.ssau.lab3.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class TemplatesController {

    private final DirectorService directorService;
    private final MovieService movieService;

    @GetMapping("/movies_template")
    public String movies_template(Model model) throws Exception {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element element = document.createElement("movies");
        ObjectToHTMLElementTransformer transformer = new ObjectToHTMLElementTransformer(document);
        List<Movie> movies = movieService.getAll();
        for (Movie movie : movies) {
            transformer.transform(element, movie, "movie");
        }
        model.addAttribute("movies", element);
        return "movies";
    }

    @GetMapping("/directors_template")
    public String directors_template(Model model) throws Exception {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element element = document.createElement("directors");
        ObjectToHTMLElementTransformer transformer = new ObjectToHTMLElementTransformer(document);
        List<Director> directors = directorService.getAll();
        for (Director director : directors) {
            transformer.transform(element, director, "director");
        }
        model.addAttribute("directors", element);
        return "directors";
    }
}
