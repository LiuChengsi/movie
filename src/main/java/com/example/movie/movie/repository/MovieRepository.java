package com.example.movie.movie.repository;

import com.example.movie.movie.dto.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
