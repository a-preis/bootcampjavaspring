package com.example.demo.Modules;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    private int id = ThreadLocalRandom.current().nextInt(1, 999);
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private int numberOfKilometers;
    private int doors;
    private BigDecimal price;
    private String currency;
    private List<Object> services;
    private int countOfOwners;

}
