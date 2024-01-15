package com.ssau.lab3.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;


@Entity
@Data
@Table(name = "directors")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;

    @OneToMany(mappedBy = "director")
    private List<Movie> movies;
}
