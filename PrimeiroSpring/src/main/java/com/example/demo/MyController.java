package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class MyController {
    //respondendo uma chamada get http
    @GetMapping("/ping")
    @ResponseBody
    public String naoTemNadaaVer() {
        return "pong";
    }

    @GetMapping("/ana")
    @ResponseBody
    public String anaverso() {
        return "Ana Preis";
    }

    @GetMapping("/lista")
    @ResponseBody
    public List<String> pegaLivros(@RequestParam String tipo) {
        if (tipo!=null) {
            if (tipo.equalsIgnoreCase("livro"))
                return Arrays.asList("Harry Potter", "Jogos vorazes", "senhor dos aneis");
        }
        return Arrays.asList("null", "sem livros");
    }

    @GetMapping("/anuncio")
    @ResponseBody
    public Anuncio retorna() {
        return new Anuncio("Ps5", 500.0);
    }
}
