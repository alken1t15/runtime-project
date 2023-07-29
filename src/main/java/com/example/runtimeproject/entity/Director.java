package com.example.runtimeproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "director")
@Getter
@Setter
@NoArgsConstructor
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Director(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
