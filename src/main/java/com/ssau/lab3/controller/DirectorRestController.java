package com.ssau.lab3.controller;

import com.ssau.lab3.models.Director;
import com.ssau.lab3.service.DirectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/directors")
@RequiredArgsConstructor
public class DirectorRestController {

    private final DirectorService directorService;

    @GetMapping(path = "/all", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Director> getAll() {
        return directorService.getAll();
    }

    @PostMapping(path = "/save", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void save(@RequestBody Director director) {
        directorService.save(director);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable Long id) {
        directorService.deleteById(id);
    }
}
