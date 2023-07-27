package com.example.runtimeproject.service;

import com.example.runtimeproject.repository.ActorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActorService {
    private final ActorRepository actorRepository;
}
