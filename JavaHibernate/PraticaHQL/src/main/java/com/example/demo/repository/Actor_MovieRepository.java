package com.example.demo.repository;

import com.example.demo.model.Actor_Movie;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface Actor_MovieRepository extends CrudRepository<Actor_Movie, Integer> {

    //Collection<Actor_Movie> findActor_MovieByMovie_
}
