package com.example.demo.repository;

import com.example.demo.model.Actors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ActorsRepository extends CrudRepository<Actors, Integer> {

    @Query(value = "select a from Actors a where a.favorite_movie_id is not null")
    List<Actors> findActorsByFavorite_movie_idExists();

    @Query(value = "select a from Actors a where a.rating > :valor")
    List<Actors> findActorsByRatingGreaterThan(@Param("valor") Float valor);


    @Query("select a from Movies m inner join Actor_Movie am on am.movie.id = m.id inner join Actors a on am.actor.id = a.id where m.title = :title")
    List<Actors> findActorsInMovies(@Param("title")String title);

}
