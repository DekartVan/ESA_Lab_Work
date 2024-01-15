package com.ssau.lab4.repository;

import com.ssau.lab4.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieRepository extends BaseRepository<Movie, Long> {

}
