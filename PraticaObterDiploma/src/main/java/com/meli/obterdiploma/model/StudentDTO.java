package com.meli.obterdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;

import java.util.List;

@Getter @Setter
public class StudentDTO {

    @NotNull(message = "Campo obrigatório")
    @NotEmpty(message = "O nome do aluno não pode ficar vazio.")
    @Pattern(regexp = "[A-Z][a-záàâãéèêíïóôõöúçñ]+", message = "O nome do aluno deve comecar com letra maiúscula.")
    @Size(max = 50, message = "O comprimento do nome não pode exceder 50 caracteres.")
    String studentName;

    String message;
    Double averageScore;

    @NotNull(message = "Campo obrigatório")
    @NotEmpty(message = "A lista não pode estar vazia.")
    List<@Valid SubjectDTO> subjects;
}
