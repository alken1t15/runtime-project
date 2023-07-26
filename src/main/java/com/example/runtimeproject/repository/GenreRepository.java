package com.example.runtimeproject.repository;

import com.example.runtimeproject.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre,Long> {
}
