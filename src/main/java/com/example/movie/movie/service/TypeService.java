package com.example.movie.movie.service;

import com.example.movie.movie.dto.Type;
import com.example.movie.movie.repository.TypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {
    private final TypeRepository typeRepository;
    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public List<Type> findAll() {
        return typeRepository.findAll();
    }


}
