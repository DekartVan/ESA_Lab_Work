package com.ssau.lab4.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
@Table(name = "directors")
public class Director extends BaseModel {
    private String name;
    private String country;

    @OneToMany(mappedBy = "director")
    private List<Movie> movies;
}
