
package com.ssau.lab3.repository;

import com.ssau.lab3.models.Movie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Movie> findAll() {
        return em.createQuery("select i from Movie i", Movie.class).getResultList();
    }

    public void save(Movie movie) {
        em.persist(movie);
    }

    public void deleteById(Long id) {
        Movie movie = em.find(Movie.class, id);
        em.remove(movie);
    }
}