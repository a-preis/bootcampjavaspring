package com.example.demo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class Person {

    private String name;
    private String lastName;
    private int age;
    private Sport sport;

    public Person (String name, String lastName, int age, Sport sport){
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.sport = sport;
    }

}
