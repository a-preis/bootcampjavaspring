package com.example.demo.repository;

import com.example.demo.model.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movies, Integer> {

    @Query(value = "select m from Movies m left join Genres g on m.genre.id = g.id where g.name = :genre")
    List<Movies> findByGenre_idEquals(@Param("genre")String genre);

    @Query(value = "select m from Movies m inner join Genres g on m.genre.id = g.id where m.genre.id = :id")
    List<Movies> findMoviesByGenre_id(@Param("id") Integer id);

    @Query(value = "select m from Movies m inner join Actor_Movie am on m.id = am.movie.id inner join Actors a on a.id = am.actor.id where a.rating = :rating")
    List<Movies> findMoviesByActorsRating(@Param("rating") Float rating);
}
