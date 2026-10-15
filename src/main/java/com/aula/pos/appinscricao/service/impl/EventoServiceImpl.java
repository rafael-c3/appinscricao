package com.aula.pos.appinscricao.service.impl;

import com.aula.pos.appinscricao.dto.EventoRequest;
import com.aula.pos.appinscricao.dto.EventoResponse;
import com.aula.pos.appinscricao.exception.BusinessRuleException;
import com.aula.pos.appinscricao.exception.ConflictException;
import com.aula.pos.appinscricao.exception.ResourceNotFoundException;
import com.aula.pos.appinscricao.mapper.EventoMapper;
import com.aula.pos.appinscricao.model.Evento;
import com.aula.pos.appinscricao.repository.EventoRepository;
import com.aula.pos.appinscricao.service.EventoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EventoServiceImpl implements EventoService {

    private static final String MSG_EVENTO_DUPLICADO =
            "Já existe um evento com o mesmo nome, data/hora e cidade";
    private static final String MSG_EVENTO_REALIZADO =
            "Não é possível excluir um evento já realizado";

    private final EventoRepository eventoRepository;
    private final EventoMapper mapper;

    @Override
    public Page<EventoResponse> findAll(String nome, String cidade, String estado, Pageable pageable) {
        Page<Evento> page;

        // Prioridade dos filtros: nome -> cidade -> estado
        if (temValor(nome)) {
            page = eventoRepository.findByNomeContainingIgnoreCase(nome.trim(), pageable);
        } else if (temValor(cidade)) {
            page = eventoRepository.findByCidadeIgnoreCase(cidade.trim(), pageable);
        } else if (temValor(estado)) {
            page = eventoRepository.findByEstadoIgnoreCase(estado.trim(), pageable);
        } else {
            page = eventoRepository.findAll(pageable);
        }

        return page.map(mapper::toResponse);
    }

    @Override
    public EventoResponse findById(UUID id) {
        return mapper.toResponse(findByIdOrThrow(id));
    }

    @Override
    @Transactional
    public EventoResponse save(EventoRequest request) {
        if (eventoRepository.existsByNomeIgnoreCaseAndDataHoraEventoAndCidadeIgnoreCase(
                request.nome(), request.dataHoraEvento(), request.cidade())) {
            throw new ConflictException(MSG_EVENTO_DUPLICADO);
        }

        var evento = mapper.toEntity(request);
        return mapper.toResponse(eventoRepository.save(evento));
    }

    @Override
    @Transactional
    public EventoResponse update(UUID id, EventoRequest request) {
        var evento = findByIdOrThrow(id);

        if (eventoRepository.existsByNomeIgnoreCaseAndDataHoraEventoAndCidadeIgnoreCaseAndIdNot(
                request.nome(), request.dataHoraEvento(), request.cidade(), id)) {
            throw new ConflictException(MSG_EVENTO_DUPLICADO);
        }

        mapper.updateEntity(request, evento);
        return mapper.toResponse(eventoRepository.save(evento));
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        var evento = findByIdOrThrow(id);

        if (evento.getDataHoraEvento().isBefore(LocalDateTime.now())) {
            throw new BusinessRuleException(MSG_EVENTO_REALIZADO);
        }

        eventoRepository.delete(evento);
    }

    private Evento findByIdOrThrow(UUID id) {
        return eventoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    private boolean temValor(String valor) {
        return valor != null && !valor.isBlank();
    }
}
