package com.example.demo.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import com.meli.obterdiploma.model.ErrorDTO;

@Getter
public class ValidacaoExeption extends RuntimeException{

    private final ErrorDTO error;
    private final HttpStatus status;

    public ValidacaoExeption(String message, HttpStatus status) {
        this.error = new ErrorDTO(this.getClass().getSimpleName(), message);
        this.status = status;
    }
}
