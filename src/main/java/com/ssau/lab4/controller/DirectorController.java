package com.ssau.lab4.controller;

import com.ssau.lab4.models.Director;
import com.ssau.lab4.repository.DirectorRepository;
import com.ssau.lab4.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DirectorController {

    private final DirectorService directorService;

    @Autowired
    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping("/directors")
    public String getAll(Model model) {
        List<Director> directors = directorService.getAll();
        model.addAttribute("directors", directors);
        return "directors";
    }

    @GetMapping("/directors/{id}")
    public String getById(@PathVariable Long id, Model model) {
        Director director = directorService.getById(id);
        model.addAttribute("director", director);
        return "director";
    }

    @GetMapping("/directors/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Director director = directorService.getById(id);
        model.addAttribute("director", director);
        return "director-edit";
    }

    @PostMapping("/directors/{id}/edit")
    public String edit(@PathVariable Long id, Director director) {
        directorService.save(director);
        return "redirect:/directors";
    }

    @GetMapping("/directors/{id}/delete")
    public String delete(@PathVariable Long id) {
        directorService.deleteById(id);
        return "redirect:/directors";
    }

    @GetMapping("/directors/add")
    public String add(Model model) {
        model.addAttribute("director", new Director());
        return "director-add";
    }

    @PostMapping("/directors/add")
    public String add(Director director) {
        directorService.save(director);
        return "redirect:/directors";
    }
}
