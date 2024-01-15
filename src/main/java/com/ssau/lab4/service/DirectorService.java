package com.ssau.lab4.service;

import com.ssau.lab4.jms.Producer;
import com.ssau.lab4.models.Director;
import com.ssau.lab4.models.EventType;
import com.ssau.lab4.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {

    private final DirectorRepository directorRepository;
    private final Producer producer;

    @Autowired
    public DirectorService(DirectorRepository directorRepository, Producer producer) {
        this.directorRepository = directorRepository;
        this.producer = producer;
    }

    public List<Director> getAll() {
        return directorRepository.findAll();
    }

    public Director getById(Long id) {
        return directorRepository.findById(id).orElse(null);
    }

    public void save(Director director) {
        directorRepository.save(director);
    }

    public void deleteById(Long id) {
        producer.sendMessage(directorRepository.findOneByUniqueId(id), EventType.delete);
        directorRepository.deleteById(id);
    }
}
