package com.ssau.lab2.controller;

import com.ssau.lab2.models.Director;
import com.ssau.lab2.repository.DirectorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DirectorController {

    private final DirectorRepository directorRepository;

    @Autowired
    public DirectorController(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @GetMapping("/directors")
    public String getAll(Model model) {
        List<Director> directors = directorRepository.findAll();
        model.addAttribute("directors", directors);
        return "directors";
    }

    @GetMapping("/directors/{id}")
    public String getById(@PathVariable Long id, Model model) {
        Director director = directorRepository.findById(id).orElse(null);
        model.addAttribute("director", director);
        return "director";
    }

    @GetMapping("/directors/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Director director = directorRepository.findById(id).orElse(null);
        model.addAttribute("director", director);
        return "director-edit";
    }

    @PostMapping("/directors/{id}/edit")
    public String edit(@PathVariable Long id, Director director) {
        directorRepository.save(director);
        return "redirect:/directors";
    }

    @GetMapping("/directors/{id}/delete")
    public String delete(@PathVariable Long id) {
        directorRepository.deleteById(id);
        return "redirect:/directors";
    }

    @GetMapping("/directors/add")
    public String add(Model model) {
        model.addAttribute("director", new Director());
        return "director-add";
    }

    @PostMapping("/directors/add")
    public String add(Director director) {
        directorRepository.save(director);
        return "redirect:/directors";
    }
}
