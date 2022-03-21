package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PessoaDTO {

    private String name;
    private String lastName;
    private String sportName;

    public PessoaDTO convert(Person pessoa) {
        this.name = pessoa.getName();
        this.lastName = pessoa.getLastName();
        this.sportName = pessoa.getSport().getName();
        return this;
    }

    public Person convert() {
        int level = ThreadLocalRandom.current().nextInt(1, 10);
        return new Person(this.name, this.lastName, 0, new Sport(this.sportName, level));
    }

    public static List<PessoaDTO> convert(List<Person> listOfPeople){
        return listOfPeople.stream().map(a -> new PessoaDTO(a.getName(), a.getLastName(), a.getSport().getName()))
                .collect(Collectors.toList());
    }

}
