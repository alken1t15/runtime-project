package com.example.runtimeproject.service;

import com.example.runtimeproject.entity.Actor;
import com.example.runtimeproject.entity.Director;
import com.example.runtimeproject.entity.Movie;
import com.example.runtimeproject.repository.ActorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ActorService {
    private final ActorRepository actorRepository;

    public List<Movie> findAllByNameStartingWith(String name) {
        List<Movie> movieList = new ArrayList<>();
        String[] arr = name.split(" ");
        if (arr.length == 2) {
            List<Actor> actors = actorRepository.findAllByNameStartingWithAndSurnameStartingWith(arr[0],arr[1]);
            for (Actor actor : actors) {
                movieList.add(actor.getMovie());
            }
        } else {
            List<Actor> actors = actorRepository.findAllByNameStartingWithOrSurnameStartingWith(name,name);
            for (Actor actor : actors) {
                movieList.add(actor.getMovie());
            }
        }
        return movieList;
    }
}