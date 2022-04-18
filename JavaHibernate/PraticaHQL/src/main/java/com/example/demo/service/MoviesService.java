package com.example.demo.service;

import com.example.demo.model.Actors;
import com.example.demo.model.Movies;
import com.example.demo.repository.ActorsRepository;
import com.example.demo.repository.GenresRepository;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class MoviesService {

    @Autowired
    ActorsRepository actorsRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    GenresRepository genresRepository;

    public List<Actors> findActorsWithFavoriteMovies(){
        return actorsRepository.findActorsByFavorite_movie_idExists();
    }

    public List<Actors> findActorsWithRatingGreaterThanValue(Float value) {
        return actorsRepository.findActorsByRatingGreaterThan(value);
    }

    public Collection<Actors> findActorsInMovie(String movieTitle) {
        return actorsRepository.findActorsInMovies(movieTitle);
    }

    public List<Movies> findMoviesByGenre(String genre){
        return movieRepository.findByGenre_idEquals(genre);
    }

    public List<Movies> findByGenre(Integer id){
        return movieRepository.findMoviesByGenre_id(id);
    }

    public List<Movies> findByActorsRating(Float rating){
        return movieRepository.findMoviesByActorsRating(rating);
    }


}
