package com.aula.pos.appinscricao.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record PessoaRequest(
        @NotBlank(message = "{messages.erro.pessoa.notblank}")
        @Size(min = 3, max = 100, message = "Nome deve possuir entre 3 a 100 caracteres")
        String nome,
        @NotBlank(message = "Cpf é Obrigatório")
        @Size(max = 15, message = "Cpf deve possuir no máximo 15 caracteres")
        String cpf,
        @NotBlank(message = "Email é Obrigatório")
        @Size(max = 100, message = "E-mail deve possuir no máximo 100 caracteres")
        @Email(message = "E-mail Inválido")
        String email,
        @NotBlank(message = "Telefone é Obrigatório")
        @Size(max = 15, message = "Telefone deve possuir no máximo 15 caracteres")
        String telefone
) {
}
