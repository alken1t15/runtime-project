package com.example.runtimeproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "movie")
@Getter
@Setter
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer year;

    private Double rating;

    private Integer count;

    @OneToMany(mappedBy = "movie")
    private List<Actor> actors;

    @OneToMany(mappedBy = "movie")
    private List<Director> directors;

    @ManyToMany()
    @JoinTable(name = "movie_to_genre",joinColumns = @JoinColumn(name = "movie_id"),inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genreList;
}
