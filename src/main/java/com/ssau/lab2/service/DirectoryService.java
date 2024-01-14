package com.ssau.lab2.service;

import com.ssau.lab2.models.Director;
import com.ssau.lab2.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectoryService {

    private final DirectorRepository directorRepository;

    @Autowired
    public DirectoryService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public List<Director> getAll() {
        return directorRepository.findAll();
    }

    public Director getById(Long id) {
        return directorRepository.findById(id).orElse(null);
    }

    public Director save(Director director) {
        return directorRepository.save(director);
    }

    public void deleteById(Long id) {
        directorRepository.deleteById(id);
    }

    public void delete(Director director) {
        directorRepository.delete(director);
    }

    public void deleteAll() {
        directorRepository.deleteAll();
    }

    public boolean existsById(Long id) {
        return directorRepository.existsById(id);
    }

    public long count() {
        return directorRepository.count();
    }

    public List<Director> saveAll(List<Director> directors) {
        return directorRepository.saveAll(directors);
    }

    public List<Director> findAllById(List<Long> ids) {
        return directorRepository.findAllById(ids);
    }

    public void deleteAll(List<Director> directors) {
        directorRepository.deleteAll(directors);
    }

}
