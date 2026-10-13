package com.aula.pos.appinscricao.repository;

import com.aula.pos.appinscricao.model.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {

    Page<Pessoa> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
}
