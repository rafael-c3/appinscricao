package com.aula.pos.appinscricao.service;

import com.aula.pos.appinscricao.dto.EventoRequest;
import com.aula.pos.appinscricao.dto.EventoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface EventoService {

    Page<EventoResponse> findAll(String nome, String cidade, String estado, Pageable pageable);
    EventoResponse findById(UUID id);
    EventoResponse save(EventoRequest request);
    EventoResponse update(UUID id, EventoRequest request);
    void deleteById(UUID id);

}