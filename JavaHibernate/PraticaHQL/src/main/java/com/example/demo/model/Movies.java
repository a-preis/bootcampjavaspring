package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movies {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String title;
    private Float rating;
    private Integer awards;
    private Date release_date;
    private Integer length;
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name="genre_id", referencedColumnName = "id")
    private Genres genre;
}
