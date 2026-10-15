package com.aula.pos.appinscricao.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_eventos")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(length = 150, nullable = false)
    private String nome;
    @Column(nullable = false)
    private LocalDateTime dataHoraEvento;
    @Column(length = 200, nullable = false)
    private String local;
    @Column(length = 100, nullable = false)
    private String cidade;
    @Column(length = 2, nullable = false)
    private String estado;
    @Column(nullable = false)
    private Integer qtde;
}