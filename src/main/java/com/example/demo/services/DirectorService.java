package com.example.demo.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import com.example.demo.repositories.DirectorRepository;
import com.example.demo.models.Director;
import java.util.List;

@Stateless
public class DirectorService {

    @Inject
    private DirectorRepository directorRepository;

    public DirectorService() {
    }

    public Director findById(Long id) {
        return directorRepository.findById(id);
    }

    public Director findByName(String name) {
        return directorRepository.findByName(name);
    }

    public List<Director> findAll() {
        return directorRepository.findAll();
    }

    public void create(Director director) {
        directorRepository.create(director);
    }

    public void update(Director director) {
        directorRepository.update(director);
    }

    public void delete(Director director) {
        directorRepository.delete(director);
    }

    public void deleteById(Long id) {
        directorRepository.deleteById(id);
    }


}
