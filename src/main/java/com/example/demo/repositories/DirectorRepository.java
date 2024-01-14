package com.example.demo.repositories;

import com.example.demo.models.Director;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;


@Stateless
public class DirectorRepository {
    @PersistenceContext
    private EntityManager em;

    public DirectorRepository(EntityManager em) {
        this.em = em;
    }

    public DirectorRepository() {
    }

    public Director findById(Long id) {
        return em.find(Director.class, id);
    }

    public Director findByName(String name) {
        return em.createQuery("SELECT d FROM Director d WHERE d.name = :name", Director.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    public List<Director> findAll() {
        return em.createQuery("SELECT d FROM Director d", Director.class).getResultList();
    }

    public void create(Director director) {
        em.persist(director);
    }

    public void update(Director director) {
        em.merge(director);
    }

    public void delete(Director director) {
        em.remove(director);
    }

    public void deleteById(Long id) {
        Director director = findById(id);
        delete(director);
    }

}
