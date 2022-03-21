package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Service {

    private static Service instance;
    private ArrayList<Sport> listOfSports;
    private ArrayList<Person> listOfPeople;

    public static Service getInstance() {
        if (instance == null) {
            instance = new Service();
            return instance;
        }
        return instance;
    }

    private Service(){
        listOfSports = new ArrayList<Sport>();
        Sport volei = new Sport("volei", 1);
        listOfSports.add(volei);
        Sport futebol = new Sport("futebol", 2);
        listOfSports.add(futebol);
        Sport basquete = new Sport("basquete", 3);
        listOfSports.add(basquete);

        listOfPeople = new ArrayList<>();
        listOfPeople.addAll(Arrays.asList(
                new Person("ana", "preis", 28, volei),
                new Person("joao", "machado", 30, futebol)
        ));
    }

    public List<String> printListOfSports(){
        List<String> list = listOfSports.stream()
                .map(a -> a.getName())
                .collect(Collectors.toList());
        return list;
    }

    public int getLevelByName(String name) {
    int level = listOfSports.stream()
            .filter(s -> s.getName().equals(name))
            .findFirst()
            .get()
            .getLevel();
    return level;
    }

    public List<Person> getListOfPeople(){
        return listOfPeople;
    }
}
