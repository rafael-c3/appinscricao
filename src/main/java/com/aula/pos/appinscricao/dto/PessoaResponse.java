package com.aula.pos.appinscricao.dto;

import java.util.UUID;

public record PessoaResponse(
        UUID id,
        String nome,
        String cpf,
        String email,
        String telefone
) {
}
