package com.example.movie.movie.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String name;

    private LocalDate releaseDate;
    private String director;
    private String country;
    private Integer duration;
    private Double note;

    @JsonIgnoreProperties(value = { "movies" })
    @ManyToMany
    @JoinTable(
            name="movie_actor",
            joinColumns=@JoinColumn(name="movie_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="actor_id", referencedColumnName="id"))
    private List<Actor> actors = new ArrayList<Actor>();

    @JsonIgnoreProperties(value = { "movies" })
    @ManyToMany
    @JoinTable(
            name="movie_type",
            joinColumns=@JoinColumn(name="movie_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="type_id", referencedColumnName="id"))
    private List<Type> type = new ArrayList<Type>();

    public Movie(@NotNull String name, LocalDate releaseDate, String director, String country,
                 Integer duration, Double note, List<Actor> actors, List<Type> type) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.director = director;
        this.country = country;
        this.duration = duration;
        this.note = note;
        this.actors = actors;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Movie() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public List<Type> getType() {
        return type;
    }

    public void setType(List<Type> type) {
        this.type = type;
    }
}
