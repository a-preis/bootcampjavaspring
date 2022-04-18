package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Actor_Movie {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private Timestamp created_at;
    private Timestamp updated_at;
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "actor_id", referencedColumnName = "id")
    private Actors actor;
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movies movie;

}
