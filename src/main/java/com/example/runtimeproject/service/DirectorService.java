package com.example.runtimeproject.service;

import com.example.runtimeproject.entity.Actor;
import com.example.runtimeproject.entity.Director;
import com.example.runtimeproject.entity.Movie;
import com.example.runtimeproject.repository.DirectorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DirectorService {
    private final DirectorRepository directorRepository;

    public List<Director> findAll() {
        return directorRepository.findAll();
    }

    public List<Movie> findAllByNameStartingWith(String name) {
        List<Movie> movieList = new ArrayList<>();
        String[] arr = name.split(" ");
        if (arr.length == 2) {
            List<Director> directors = directorRepository.findAllByNameStartingWithAndSurnameStartingWith(arr[0], arr[1]);
            for (Director director : directors) {
                movieList.add(director.getMovie());
            }
        } else {
            List<Director> directors = directorRepository.findAllByNameStartingWithOrSurnameStartingWith(name, name);
            for (Director director : directors) {
                movieList.add(director.getMovie());
            }
        }
        return movieList;
    }
}