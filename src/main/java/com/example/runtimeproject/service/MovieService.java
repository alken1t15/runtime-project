package com.example.runtimeproject.service;

import com.example.runtimeproject.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
}
