package com.example.runtimeproject.service;

import com.example.runtimeproject.entity.Actor;
import com.example.runtimeproject.entity.Director;
import com.example.runtimeproject.entity.Movie;
import com.example.runtimeproject.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final DirectorService directorService;
    private final ActorService actorService;

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public List<Movie> findByNameAndYearAndDirectorsAndActors(String name, Integer year, String director, String actor) {
        String[] directorName = director.split(" ");
        String[] actorName = actor.split(" ");
        if (directorName.length == 2 && actorName.length== 2) {
            return movieRepository.findMovie(name,year,directorName[0],directorName[1],actorName[0],actorName[1]);
        }
        else if (directorName.length != 2 && actorName.length== 2){
            return movieRepository.findMovie(name,year,director,actorName[0],actorName[1]);
        }
        else {

        }
        return null;

    }

    public List<Movie> findAllByNameStartingWith(String name){
        return movieRepository.findAllByNameStartingWith(name);
    }

    public List<Movie> findAllByYear(Integer year){
        return movieRepository.findAllByYear(year);
    }

}