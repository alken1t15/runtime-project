package com.example.runtimeproject.controller;

import com.example.runtimeproject.entity.Director;
import com.example.runtimeproject.entity.Genre;
import com.example.runtimeproject.entity.Movie;
import com.example.runtimeproject.service.DirectorService;
import com.example.runtimeproject.service.GenreService;
import com.example.runtimeproject.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/get")
@AllArgsConstructor
public class MainController {

    private final MovieService movieService;
    private final GenreService genreService;
    private final DirectorService directorService;

    @GetMapping("/movie")
    public List<Movie> movieList(){
        return movieService.findAll();
    }

    @GetMapping("/genre")
    private List<Genre> genreList(){
        return genreService.findAll();
    }
    @GetMapping("/director")
    public List<Director> directorList()  {
        return directorService.findAll();
    }
}
