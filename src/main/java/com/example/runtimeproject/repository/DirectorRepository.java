package com.example.runtimeproject.repository;

import com.example.runtimeproject.entity.Director;
import com.example.runtimeproject.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DirectorRepository extends JpaRepository<Director,Long> {

    List<Director> findAllByNameStartingWithAndSurnameStartingWith(String name, String surname);

    List<Director> findAllByNameStartingWithOrSurnameStartingWith(String name, String surname);
}
