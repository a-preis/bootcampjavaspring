package com.meli.obterdiploma.model;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {

    @NotNull(message = "Campo obrigatório")
    @NotEmpty(message = "O nome do assunto não pode ficar vazio")
    @Pattern(regexp = "[A-Z][a-záàâãéèêíïóôõöúçñ]+", message = "O nome do assunto deve começar com letra maiúscula.")
    @Size(max = 30, message = "O comprimento do nome não pode exceder 30 caracteres.")
    String name;

    @NotNull(message = "Campo obrigatório")
    @DecimalMax(value = "10.0", message = "A nota máxima da disciplina é de 10 pontos.")
    @DecimalMin(value = "0.0", message = "A nota mínima para a disciplina é de 0 pts.")
    Double score;
}
