package com.example.demo;

import org.springframework.web.bind.annotation.*;
import static com.example.demo.Idade.idade;

@RestController
public class ApiController {

    @GetMapping("/{day}/{month}/{year}")
    @ResponseBody
    public String retornaIdade(@PathVariable int day,
                            @PathVariable int month,
                            @PathVariable int year) {

        return "Sua idade é: " + idade(day, month, year);
    }
}
