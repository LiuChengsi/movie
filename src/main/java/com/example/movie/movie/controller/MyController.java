package com.example.movie.movie.controller;

import com.example.movie.movie.dto.Actor;
import com.example.movie.movie.dto.Movie;
import com.example.movie.movie.dto.Type;
import com.example.movie.movie.service.ActorService;
import com.example.movie.movie.service.MovieService;
import com.example.movie.movie.service.TypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MyController {
    private final Logger LOGGER = LoggerFactory.getLogger(MyController.class);
    private final MovieService movieService;
    private final ActorService actorService;
    private final TypeService typeService;

    public MyController(MovieService movieService, ActorService actorService, TypeService typeService) {
        this.movieService = movieService;
        this.actorService = actorService;
        this.typeService = typeService;
    }

    @GetMapping("/movieList")
    public ResponseEntity<List<Movie>> findAllMovie() {
        try {
            List<Movie> movie = movieService.findAll();
            return new ResponseEntity<>(movie, HttpStatus.OK);
        } catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity findOneMovie(@PathVariable Integer id) {
        try {
            Movie findMovie = movieService.findById(id);
            return new ResponseEntity<>(findMovie, HttpStatus.OK);
        } catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/newMovie")
    public ResponseEntity createMovie(@RequestBody Movie movie) {
        try {
            Movie createMovie = movieService.create(movie);
            return new ResponseEntity<>(createMovie, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/movie/{id}")
    public ResponseEntity updateMovie(@RequestBody Movie movie, @PathVariable Integer id) {
        try {
            Movie updateMovie = movieService.update(movie, id);
            return new ResponseEntity<>(updateMovie, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/movie/{id}")
    public ResponseEntity deleteMovie(@PathVariable Integer id) {
        if(movieService.delete(id)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/noteList")
    public ResponseEntity noteList() {
        try {
            List<Movie> listMovie  = movieService.noteList();
            return new ResponseEntity<>(listMovie, HttpStatus.OK);
        } catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/actorList")
    public ResponseEntity<List<Actor>> findAllActor() {
        try {
            List<Actor> actor = actorService.findAll();
            return new ResponseEntity<>(actor, HttpStatus.OK);
        } catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/newActor")
    public ResponseEntity createActor(@RequestBody Actor actor) {
        try {
            Actor createActor = actorService.create(actor);
            return new ResponseEntity<>(createActor, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/typeList")
    public ResponseEntity<List<Type>> findAllType(){
        try {
            List<Type> type = typeService.findAll();
            return new ResponseEntity<>(type, HttpStatus.OK);
        } catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
