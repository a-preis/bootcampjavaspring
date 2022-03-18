package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.Period;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Idade {

    private int day;
    private int month;
    private int year;

    public static int idade(int day, int month, int year) {
        LocalDate aniversario = LocalDate.of(year, month, day);
        final LocalDate dataAtual = LocalDate.now();
        final Period periodo = Period.between(aniversario, dataAtual);
        return periodo.getYears();
    }
}
