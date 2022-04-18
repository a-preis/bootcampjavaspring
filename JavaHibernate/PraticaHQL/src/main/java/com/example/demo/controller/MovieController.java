package com.example.demo.controller;

import com.example.demo.model.Actors;
import com.example.demo.model.Movies;
import com.example.demo.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MoviesService moviesService;

    @GetMapping("/actorsFavoriteMovieExists/")
    public ResponseEntity<List<Actors>> findActorsWithFavoriteMovies() {
        return ResponseEntity.ok(moviesService.findActorsWithFavoriteMovies());
    }

    @GetMapping("/actorsWithRatingGreaterThan/{value}/")
    public ResponseEntity<List<Actors>> findActorsWithFavoriteMovies(@PathVariable Float value) {
        return ResponseEntity.ok(moviesService.findActorsWithRatingGreaterThanValue(value));
    }

    @GetMapping("/actorsOnMovie/{movieTitle}/")
    public ResponseEntity<Collection<Actors>> findActorsWithFavoriteMovies(@PathVariable String movieTitle) {
        return ResponseEntity.ok(moviesService.findActorsInMovie(movieTitle));
    }

    @GetMapping("/moviesbygenrename/{genre}")
    public ResponseEntity<List<Movies>> findMovieByGenreName(@PathVariable String genre) {
        return ResponseEntity.ok(moviesService.findMoviesByGenre(genre));
    }

    @GetMapping("/moviesbygenre/{genre_id}")
    public ResponseEntity<List<Movies>> findMovieByGenreName(@PathVariable Integer genre_id) {
        return ResponseEntity.ok(moviesService.findByGenre(genre_id));
    }

    @GetMapping("/moviesbyactorsrating/{rating}")
    public ResponseEntity<List<Movies>> findMovieByActorsRating(@PathVariable Float rating) {
        return ResponseEntity.ok(moviesService.findByActorsRating(rating));
    }
}
