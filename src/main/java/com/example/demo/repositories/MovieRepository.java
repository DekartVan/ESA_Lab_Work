package com.example.demo.repositories;

import com.example.demo.models.Movie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class MovieRepository {

    @PersistenceContext
    private EntityManager em;

    public MovieRepository(EntityManager em) {
        this.em = em;
    }

    public MovieRepository() {
    }

    public Movie findById(Long id) {
        return em.find(Movie.class, id);
    }

    public List<Movie> findAll() {
        return em.createQuery("SELECT m FROM Movie m", Movie.class).getResultList();
    }

    public void create(Movie movie) {
        em.persist(movie);
    }

    public void update(Movie movie) {
        em.merge(movie);
    }

    public void delete(Movie movie) {
        em.remove(movie);
    }

    public void deleteById(Long id) {
        Movie movie = findById(id);
        delete(movie);
    }

}
