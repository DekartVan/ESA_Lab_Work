package com.ssau.lab2.models;

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
    private Date birthdate;

    @OneToMany(mappedBy = "director")
    private List<Movie> movies;
}
