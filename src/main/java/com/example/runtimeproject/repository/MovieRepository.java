package com.example.runtimeproject.repository;

import com.example.runtimeproject.entity.Actor;
import com.example.runtimeproject.entity.Director;
import com.example.runtimeproject.entity.Movie;
import org.hibernate.annotations.SQLSelect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("select m FROM Movie m inner join Director d on m.id = d.movie.id inner join Actor a on m.id = a.movie.id where ?1 = m.name and ?2 = m.year and ?3= d.name and ?4= d.surname and ?5= a.name and ?6 = a.surname")
    List<Movie> findMovie(String nameFilm, Integer year, String nameDirector, String surnameDirector, String nameActor, String surnameActor);

    @Query("select m FROM Movie m inner join Director d on m.id = d.movie.id inner join Actor a on m.id = a.movie.id where ?1 = m.name and ?2 = m.year and ?3= d.name and ?4= a.name and ?5 = a.surname")
    List<Movie> findMovie(String nameFilm, Integer year, String nameDirector, String nameActor, String surnameActor);

    List<Movie> findAllByNameStartingWith(String name);

    List<Movie> findAllByYear(Integer year);

}