package com.aula.pos.appinscricao.mapper;

import com.aula.pos.appinscricao.dto.PessoaRequest;
import com.aula.pos.appinscricao.dto.PessoaResponse;
import com.aula.pos.appinscricao.model.Pessoa;
import org.springframework.stereotype.Component;

@Component
public class PessoaMapper {

    public Pessoa toEntity(PessoaRequest request){
        return new Pessoa(
                null,
                request.nome(),
                request.cpf(),
                request.email(),
                request.telefone()
        );
    }

    public void updateEntity(PessoaRequest request, Pessoa pessoa){
        pessoa.setNome(request.nome());
        pessoa.setCpf(request.cpf());
        pessoa.setEmail(request.email());
        pessoa.setTelefone(request.telefone());
    }


    public PessoaResponse toResponse(Pessoa pessoa){
        return new PessoaResponse(
                pessoa.getId(),
                pessoa.getNome(),
                pessoa.getCpf(),
                pessoa.getEmail(),
                pessoa.getTelefone()
        );
    }

}
