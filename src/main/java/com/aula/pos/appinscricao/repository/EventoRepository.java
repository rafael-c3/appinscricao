package com.aula.pos.appinscricao.repository;


import com.aula.pos.appinscricao.model.Evento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.UUID;

@Repository
public interface EventoRepository extends JpaRepository<Evento, UUID> {

    Page<Evento> findByNomeContainingIgnoreCase(String nome, Pageable pageable);

    Page<Evento> findByCidadeIgnoreCase(String cidade, Pageable pageable);

    Page<Evento> findByEstadoIgnoreCase(String estado, Pageable pageable);

    // Evento duplicado no cadastro
    boolean existsByNomeIgnoreCaseAndDataHoraEventoAndCidadeIgnoreCase(
            String nome, LocalDateTime dataHoraEvento, String cidade);

    // Evento duplicado na atualização (desconsidera o próprio evento)
    boolean existsByNomeIgnoreCaseAndDataHoraEventoAndCidadeIgnoreCaseAndIdNot(
            String nome, LocalDateTime dataHoraEvento, String cidade, UUID id);
}
