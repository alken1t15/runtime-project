package com.example.runtimeproject.repository;

import com.example.runtimeproject.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor,Long> {

}