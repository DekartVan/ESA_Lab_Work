package com.ssau.lab3.service;

import com.ssau.lab3.models.Director;
import com.ssau.lab3.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;


import java.util.List;

@Service
public class DirectorService {

    private final DirectorRepository directorRepository;

    @Autowired
    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public List<Director> getAll() {
        return directorRepository.findAll();
    }

    @Transactional
    public void save(Director director) {
        directorRepository.save(director);
    }

    @Transactional
    public void deleteById(Long id) {
        directorRepository.deleteById(id);
    }
}
