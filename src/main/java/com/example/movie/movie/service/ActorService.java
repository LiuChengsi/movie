package com.example.movie.movie.service;

import com.example.movie.movie.dto.Actor;
import com.example.movie.movie.repository.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ActorService {
    private final ActorRepository actorRepository;
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    public Actor create(Actor actor)
    {
        return actorRepository.save(actor);
    }

}
