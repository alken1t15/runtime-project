package com.example.runtimeproject.controller;

import com.example.runtimeproject.entity.Director;
import com.example.runtimeproject.entity.Genre;
import com.example.runtimeproject.entity.Movie;
import com.example.runtimeproject.service.ActorService;
import com.example.runtimeproject.service.DirectorService;
import com.example.runtimeproject.service.GenreService;
import com.example.runtimeproject.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/movie")
@AllArgsConstructor
public class MainController {

    private final MovieService movieService;
    private final GenreService genreService;
    private final DirectorService directorService;
    private final ActorService actorService;

    @GetMapping
    public String mainPage(@RequestParam(required = false) String name, @RequestParam(required = false) Integer year, @RequestParam(required = false) String director,
                           @RequestParam(required = false) String actor, Model model) {
        List<Movie> movieList = null;
        if (name == null) {
            movieList = movieService.findAll();
        } else if (!name.isEmpty() && year != null && !director.isEmpty() && !actor.isEmpty()) {
            movieList = movieService.findByNameAndYearAndDirectorsAndActors(name, year, director, actor);
        } else if (!name.isEmpty() && year != null && !director.isEmpty() && actor.isEmpty()) {
            movieList = movieService.findMovieNameYearDirector(name, year, director);
        } else if (!name.isEmpty() && year != null && director.isEmpty() && !actor.isEmpty()) {
            movieList = movieService.findMovieNameYearActor(name, year, actor);
        } else if (!name.isEmpty() && year != null && director.isEmpty() && actor.isEmpty()) {
            movieList = movieService.findMovieNameYear(name, year);
        } else if (!name.isEmpty() && year == null && !director.isEmpty() && !actor.isEmpty()) {
            movieList = movieService.findMovieNameDirectorActor(name, director, actor);
        } else if (!name.isEmpty() && year == null && !director.isEmpty() && actor.isEmpty()) {
            movieList = movieService.findMovieNameDirector(name, director);
        } else if (!name.isEmpty() && year == null && director.isEmpty() && !actor.isEmpty()) {
            movieList = movieService.findMovieNameActor(name, actor);
        } else if (name.isEmpty() && year != null && !director.isEmpty() && !actor.isEmpty()) {
            movieList = movieService.findMovieYearDirectorActor(year, director, actor);
        } else if (name.isEmpty() && year != null && !director.isEmpty() && actor.isEmpty()) {
            movieList = movieService.findMovieYearDirector(year, director);
        } else if (name.isEmpty() && year != null && director.isEmpty() && !actor.isEmpty()) {
            movieList = movieService.findMovieYearActor(year, actor);
        } else if (name.isEmpty() && year != null && !director.isEmpty() && !actor.isEmpty()) {
            movieList = movieService.findMovieDirectorActor(director, actor);
        } else if (!name.isEmpty() && year == null && director.isEmpty() && actor.isEmpty()) {
            movieList = movieService.findAllByNameStartingWith(name);
        } else if (name.isEmpty() && year != null && director.isEmpty() && actor.isEmpty()) {
            movieList = movieService.findAllByYear(year);
        } else if (name.isEmpty() && year == null && !director.isEmpty() && actor.isEmpty()) {
            movieList = directorService.findAllByNameStartingWith(director);
        } else if (name.isEmpty() && year == null && director.isEmpty() && !actor.isEmpty()) {
            movieList = actorService.findAllByNameStartingWith(actor);
        } else {
            movieList = movieService.findAll();
        }
        model.addAttribute("movieList", movieList);
        return "main_page";
    }
}