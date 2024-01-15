package com.ssau.lab4.models;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "movies")
public class Movie extends BaseModel {
    private String title;
    private int year;
    private int rating;

    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    private Director director;
}
