package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Anuncio {

    private String titulo;
    private double valor;
}
