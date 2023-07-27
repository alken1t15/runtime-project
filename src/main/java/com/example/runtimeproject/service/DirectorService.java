package com.example.runtimeproject.service;

import com.example.runtimeproject.repository.DirectorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DirectorService {
    private final DirectorRepository directorRepository;
}
