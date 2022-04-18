package com.example.demo.repository;

import com.example.demo.model.Actors;
import com.example.demo.model.Genres;
import com.example.demo.model.Movies;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenresRepository extends JpaRepository<Genres, Integer> {


}
