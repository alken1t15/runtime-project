package com.example.runtimeproject.service;

import com.example.runtimeproject.repository.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;
}