package com.ssau.lab2.models;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int year;
    private int rating;

    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    private Director director;
}