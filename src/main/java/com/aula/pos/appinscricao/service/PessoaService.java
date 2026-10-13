package com.aula.pos.appinscricao.service;

import com.aula.pos.appinscricao.dto.PessoaRequest;
import com.aula.pos.appinscricao.dto.PessoaResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface PessoaService {

    Page<PessoaResponse> findAll(String nome, Pageable pageable);
    PessoaResponse findById(UUID id);
    PessoaResponse save(PessoaRequest request);
    PessoaResponse update(UUID id, PessoaRequest request);
    void deleById(UUID id);

}
