package com.example.runtimeproject.service;

import com.example.runtimeproject.entity.Director;
import com.example.runtimeproject.repository.DirectorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DirectorService {
    private final DirectorRepository directorRepository;

    public List<Director> findAll() {
        return directorRepository.findAll();
    }
}
