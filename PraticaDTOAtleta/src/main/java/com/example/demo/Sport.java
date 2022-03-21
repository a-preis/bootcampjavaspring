package com.example.demo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@ToString
public class Sport {

    private String name;
    private int level;
    public static List<Sport> listOfSports = new ArrayList<>();

    public Sport(String name, int level) {
        this.name = name;
        this.level = level;
        listOfSports.add(this);
    }

}
