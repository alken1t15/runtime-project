package com.example.runtimeproject.repository;

import com.example.runtimeproject.entity.Actor;
import com.example.runtimeproject.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor,Long> {
    List<Actor> findAllByNameStartingWithAndSurnameStartingWith(String name, String surname);

    List<Actor> findAllByNameStartingWithOrSurnameStartingWith(String name, String surname);
}