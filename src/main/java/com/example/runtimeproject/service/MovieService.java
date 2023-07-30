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
        if (directorName.length == 2 && actorName.length == 2) {
            return movieRepository.findMovie(name, year, directorName[0], directorName[1], actorName[0], actorName[1]);
        } else if (directorName.length != 2 && actorName.length == 2) {
            return movieRepository.findMovie(name, year, director, actorName[0], actorName[1]);
        } else if (directorName.length == 2 && actorName.length != 2) {
            return movieRepository.findMovieActor(name, year, directorName[0], directorName[1], actor);
        } else {
            return movieRepository.findMovie(name, year, director, actor);
        }
    }

    public List<Movie> findAllByNameStartingWith(String name) {
        return movieRepository.findAllByNameStartingWith(name);
    }

    public List<Movie> findAllByYear(Integer year) {
        return movieRepository.findAllByYear(year);
    }

    public List<Movie> findMovieNameYearDirector(String name, Integer year, String director) {
        String[] directorName = director.split(" ");
        if (directorName.length == 2) {
            return movieRepository.findMovieNameYearDirector(name, year, directorName[0], directorName[1]);
        } else {
            return movieRepository.findMovieNameYearDirector(name, year, director);
        }
    }

    public List<Movie> findMovieNameYearActor(String name, Integer year, String actor) {
        String[] actorName = actor.split(" ");
        if (actorName.length == 2) {
            return movieRepository.findMovieNameYearActor(name, year, actorName[0], actorName[1]);
        } else {
            return movieRepository.findMovieNameYearActor(name, year, actor);
        }
    }

    public List<Movie> findMovieNameYear(String name, Integer year) {
        return movieRepository.findMovieNameYear(name, year);
    }

    public List<Movie> findMovieNameDirectorActor(String name, String director, String actor) {
        String[] directorName = director.split(" ");
        String[] actorName = actor.split(" ");
        if (directorName.length == 2 && actorName.length == 2) {
            return movieRepository.findMovieNameDirectorActor(name, directorName[0], directorName[1], actorName[0], actorName[1]);
        } else if (directorName.length != 2 && actorName.length == 2) {
            return movieRepository.findMovieNameDirectorActor(name, director, actorName[0], actorName[1]);
        } else if (directorName.length == 2 && actorName.length != 2) {
            return movieRepository.findMovieNameDirectorActorOne(name, directorName[0], directorName[1], actor);
        } else {
            return movieRepository.findMovieNameDirectorActor(name, director, actor);
        }
    }

    public List<Movie> findMovieNameDirector(String name, String director) {
        String[] directorName = director.split(" ");
        if (directorName.length == 2) {
            return movieRepository.findMovieNameDirector(name, directorName[0], directorName[1]);
        } else {
            return movieRepository.findMovieNameDirector(name, director);
        }
    }

    public List<Movie> findMovieNameActor(String name, String actor) {
        String[] actorName = actor.split(" ");
        if (actorName.length == 2) {
            return movieRepository.findMovieNameActor(name, actorName[0], actorName[1]);
        } else {
            return movieRepository.findMovieNameActor(name, actor);
        }
    }

    public List<Movie> findMovieYearDirectorActor(Integer year, String director, String actor) {
        String[] directorName = director.split(" ");
        String[] actorName = actor.split(" ");
        if (directorName.length == 2 && actorName.length == 2) {
            return movieRepository.findMovieYearDirectorActor(year, directorName[0], directorName[1], actorName[0], actorName[1]);
        } else if (directorName.length != 2 && actorName.length == 2) {
            return movieRepository.findMovieYearDirectorActor(year, director, actorName[0], actorName[1]);
        } else if (directorName.length == 2 && actorName.length != 2) {
            return movieRepository.findMovieYearDirectorActorOne(year, directorName[0], directorName[1], actor);
        } else {
            return movieRepository.findMovieYearDirectorActor(year, director, actor);
        }
    }

    public List<Movie> findMovieYearDirector(Integer year, String director) {
        String[] directorName = director.split(" ");
        if (directorName.length == 2) {
            return movieRepository.findMovieYearDirector(year, directorName[0], directorName[1]);
        } else {
            return movieRepository.findMovieYearDirector(year, director);
        }
    }

    public List<Movie> findMovieYearActor(Integer year, String actor) {
        String[] actorName = actor.split(" ");
        if (actorName.length == 2) {
            return movieRepository.findMovieYearActor(year, actorName[0], actorName[1]);
        } else {
            return movieRepository.findMovieYearActor(year, actor);
        }
    }

    public List<Movie> findMovieDirectorActor(String director, String actor) {
        String[] directorName = director.split(" ");
        String[] actorName = actor.split(" ");
        if (directorName.length == 2 && actorName.length == 2) {
            return movieRepository.findMovieDirectorActor(directorName[0], directorName[1], actorName[0], actorName[1]);
        } else if (directorName.length != 2 && actorName.length == 2) {
            return movieRepository.findMovieDirectorActor(director, actorName[0], actorName[1]);
        } else if (directorName.length == 2 && actorName.length != 2) {
            return movieRepository.findMovieDirectorActorOne(directorName[0], directorName[1], actor);
        } else {
            return movieRepository.findMovieDirectorActor(director, actor);
        }
    }
}