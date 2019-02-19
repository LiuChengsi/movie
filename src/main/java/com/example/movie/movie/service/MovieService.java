package com.example.movie.movie.service;

import com.example.movie.movie.dto.Movie;
import com.example.movie.movie.repository.ActorRepository;
import com.example.movie.movie.repository.MovieRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final ActorRepository actorRepository;

    public MovieService(MovieRepository movieRepository, ActorRepository actorRepository) {
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Movie findById(Integer id){
        return movieRepository.findById(id).orElse(null);
    }

    public Movie create(Movie movie)
    {
        return movieRepository.save(movie);
    }

    public Movie update(Movie movie, Integer id) {
        movie.setId(id);
        return movieRepository.save(movie);
    }

    public boolean delete(Integer id) {
        try {
            Movie deletemovie = movieRepository.findById(id).orElse(null);
            movieRepository.delete(deletemovie);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }

    public List<Movie> noteList(){
        Sort sort = new Sort(Sort.Direction.DESC, "note");
        List<Movie> list = movieRepository.findAll(sort);
        return list;
    }
}
