package com.aula.pos.appinscricao.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record EventoRequest(
        @NotBlank(message = "Nome é obrigatório")
        @Size(max = 150, message = "Nome deve possuir no máximo 150 caracteres")
        String nome,
        @NotNull(message = "Data e hora do evento é obrigatório")
        @Future(message = "Data e hora do evento deve estar no futuro")
        LocalDateTime dataHoraEvento,
        @NotBlank(message = "Local é obrigatório")
        @Size(max = 200, message = "Local deve possuir no máximo 200 caracteres")
        String local,
        @NotBlank(message = "Cidade é obrigatória")
        @Size(max = 100, message = "Cidade deve possuir no máximo 100 caracteres")
        String cidade,
        @NotBlank(message = "Estado é obrigatório")
        @Size(min = 2, max = 2, message = "Estado deve possuir exatamente 2 caracteres")
        String estado,
        @NotNull(message = "Quantidade de vagas é obrigatória")
        @Min(value = 1, message = "Quantidade de vagas deve ser no mínimo 1")
        Integer qtde
) {
}
