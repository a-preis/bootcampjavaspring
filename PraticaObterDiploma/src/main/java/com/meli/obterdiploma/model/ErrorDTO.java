package com.meli.obterdiploma.model;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorDTO {

    private String tipo;
    private String mensagem;
}