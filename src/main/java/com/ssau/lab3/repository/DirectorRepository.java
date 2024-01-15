
package com.ssau.lab3.repository;

import com.ssau.lab3.models.Director;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DirectorRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Director> findAll() {
        return em.createQuery("select i from Director i", Director.class).getResultList();
    }

    public void save(Director director) {
        em.persist(director);
    }

    public void deleteById(Long id) {
        Director director = em.find(Director.class, id);
        em.remove(director);
    }
}