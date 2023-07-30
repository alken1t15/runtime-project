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

    @Query("select m FROM Movie m inner join Director d on m.id = d.movie.id inner join Actor a on m.id = a.movie.id where ?1 = m.name and ?2 = m.year and ?3= d.name or ?3= d.surname and ?4= a.name and ?5 = a.surname")
    List<Movie> findMovie(String nameFilm, Integer year, String nameDirector, String nameActor, String surnameActor);

    @Query("select m FROM Movie m inner join Director d on m.id = d.movie.id inner join Actor a on m.id = a.movie.id where ?1 = m.name and ?2 = m.year and ?3= d.name and ?4= d.surname and ?5= a.name or ?5 = a.surname")
    List<Movie> findMovieActor(String nameFilm, Integer year, String nameDirector, String surnameDirector, String nameActor);

    @Query("select m FROM Movie m inner join Director d on m.id = d.movie.id inner join Actor a on m.id = a.movie.id where ?1 = m.name and ?2 = m.year and ?3= d.name or ?3= d.surname and ?4= a.name or ?4 = a.surname")
    List<Movie> findMovie(String nameFilm, Integer year, String nameDirector, String nameActor);

    @Query("select m FROM Movie m inner join Director d on m.id = d.movie.id  where ?1 = m.name and ?2 = m.year and ?3= d.name and ?4= d.surname")
    List<Movie> findMovieNameYearDirector(String nameFilm, Integer year, String nameDirector, String surnameDirector);

    @Query("select m FROM Movie m inner join Director d on m.id = d.movie.id  where ?1 = m.name and ?2 = m.year and ?3= d.name or ?3= d.surname")
    List<Movie> findMovieNameYearDirector(String nameFilm, Integer year, String nameDirector);

    @Query("select m FROM Movie m inner join Actor a on m.id = a.movie.id where ?1 = m.name and ?2 = m.year  and ?3= a.name and ?4 = a.surname")
    List<Movie> findMovieNameYearActor(String nameFilm, Integer year, String nameActor, String surnameActor);

    @Query("select m FROM Movie m inner join Actor a on m.id = a.movie.id where ?1 = m.name and ?2 = m.year  and ?3= a.name or ?3 = a.surname")
    List<Movie> findMovieNameYearActor(String nameFilm, Integer year, String nameActor);


    @Query("select m FROM Movie m  where ?1 = m.name and ?2 = m.year")
    List<Movie> findMovieNameYear(String nameFilm, Integer year);

    @Query("select m FROM Movie m inner join Director d on m.id = d.movie.id inner join Actor a on m.id = a.movie.id where ?1 = m.name  and ?2= d.name and ?3= d.surname and ?4= a.name and ?5 = a.surname")
    List<Movie> findMovieNameDirectorActor(String nameFilm, String nameDirector, String surnameDirector, String nameActor, String surnameActor);

    @Query("select m FROM Movie m inner join Director d on m.id = d.movie.id inner join Actor a on m.id = a.movie.id where ?1 = m.name and ?2= d.name or ?2= d.surname and ?3= a.name and ?4 = a.surname")
    List<Movie> findMovieNameDirectorActor(String nameFilm, String nameDirector, String nameActor, String surnameActor);

    @Query("select m FROM Movie m inner join Director d on m.id = d.movie.id inner join Actor a on m.id = a.movie.id where ?1 = m.name  and ?2= d.name and ?3= d.surname and ?4= a.name or ?4 = a.surname")
    List<Movie> findMovieNameDirectorActorOne(String nameFilm, String nameDirector, String surnameDirector, String nameActor);

    @Query("select m FROM Movie m inner join Director d on m.id = d.movie.id inner join Actor a on m.id = a.movie.id where ?1 = m.name and ?2= d.name or ?2= d.surname and ?3= a.name or ?3 = a.surname")
    List<Movie> findMovieNameDirectorActor(String nameFilm, String nameDirector, String nameActor);


    @Query("select m FROM Movie m inner join Director d on m.id = d.movie.id  where ?1 = m.name  and ?2= d.name and ?3= d.surname")
    List<Movie> findMovieNameDirector(String nameFilm, String nameDirector, String surnameDirector);

    @Query("select m FROM Movie m inner join Director d on m.id = d.movie.id  where ?1 = m.name  and ?2= d.name or ?2= d.surname")
    List<Movie> findMovieNameDirector(String nameFilm, String nameDirector);

    @Query("select m FROM Movie m inner join Actor a on m.id = a.movie.id where ?1 = m.name and ?2= a.name and ?3 = a.surname")
    List<Movie> findMovieNameActor(String nameFilm, String nameActor, String surnameActor);

    @Query("select m FROM Movie m inner join Actor a on m.id = a.movie.id where ?1 = m.name and ?2= a.name or ?2 = a.surname")
    List<Movie> findMovieNameActor(String nameFilm, String nameActor);


    @Query("select m FROM Movie m inner join Director d on m.id = d.movie.id inner join Actor a on m.id = a.movie.id where ?1 = m.year  and ?2= d.name and ?3= d.surname and ?4= a.name and ?5 = a.surname")
    List<Movie> findMovieYearDirectorActor(Integer year, String nameDirector, String surnameDirector, String nameActor, String surnameActor);

    @Query("select m FROM Movie m inner join Director d on m.id = d.movie.id inner join Actor a on m.id = a.movie.id where ?1 = m.year and ?2= d.name or ?2= d.surname and ?3= a.name and ?4 = a.surname")
    List<Movie> findMovieYearDirectorActor(Integer year, String nameDirector, String nameActor, String surnameActor);

    @Query("select m FROM Movie m inner join Director d on m.id = d.movie.id inner join Actor a on m.id = a.movie.id where ?1 = m.year  and ?2= d.name and ?3= d.surname and ?4= a.name or ?4 = a.surname")
    List<Movie> findMovieYearDirectorActorOne(Integer year, String nameDirector, String surnameDirector, String nameActor);

    @Query("select m FROM Movie m inner join Director d on m.id = d.movie.id inner join Actor a on m.id = a.movie.id where ?1 = m.year and ?2= d.name or ?2= d.surname and ?3= a.name or ?3 = a.surname")
    List<Movie> findMovieYearDirectorActor(Integer year, String nameDirector, String nameActor);

    @Query("select m FROM Movie m inner join Director d on m.id = d.movie.id  where ?1 = m.year  and ?2= d.name and ?3= d.surname")
    List<Movie> findMovieYearDirector(Integer year, String nameDirector, String surnameDirector);

    @Query("select m FROM Movie m inner join Director d on m.id = d.movie.id  where ?1 = m.year  and ?2= d.name or ?2= d.surname")
    List<Movie> findMovieYearDirector(Integer year, String nameDirector);

    @Query("select m FROM Movie m inner join Actor a on m.id = a.movie.id where ?1 = m.year and ?2= a.name and ?3 = a.surname")
    List<Movie> findMovieYearActor(Integer year, String nameActor, String surnameActor);

    @Query("select m FROM Movie m inner join Actor a on m.id = a.movie.id where ?1 = m.year and ?2= a.name or ?2 = a.surname")
    List<Movie> findMovieYearActor(Integer year, String nameActor);


    @Query("select m FROM Movie m inner join Director d on m.id = d.movie.id inner join Actor a on m.id = a.movie.id where  ?1= d.name and ?2= d.surname and ?3= a.name and ?4 = a.surname")
    List<Movie> findMovieDirectorActor(String nameDirector, String surnameDirector, String nameActor, String surnameActor);

    @Query("select m FROM Movie m inner join Director d on m.id = d.movie.id inner join Actor a on m.id = a.movie.id where  ?1= d.name or ?1= d.surname and ?2= a.name and ?3 = a.surname")
    List<Movie> findMovieDirectorActor(String nameDirector, String nameActor, String surnameActor);

    @Query("select m FROM Movie m inner join Director d on m.id = d.movie.id inner join Actor a on m.id = a.movie.id where ?1= d.name and ?2= d.surname and ?3= a.name or ?3 = a.surname")
    List<Movie> findMovieDirectorActorOne(String nameDirector, String surnameDirector, String nameActor);

    @Query("select m FROM Movie m inner join Director d on m.id = d.movie.id inner join Actor a on m.id = a.movie.id where  ?1= d.name or ?1= d.surname and ?2= a.name or ?2 = a.surname")
    List<Movie> findMovieDirectorActor(String nameDirector, String nameActor);

    List<Movie> findAllByNameStartingWith(String name);

    List<Movie> findAllByYear(Integer year);

}