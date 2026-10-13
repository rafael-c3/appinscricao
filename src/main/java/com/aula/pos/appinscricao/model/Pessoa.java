package com.aula.pos.appinscricao.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_pessoas")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(length = 100, nullable = false)
    private String nome;
    @Column(length = 15, nullable = false, unique = true)
    private String cpf;
    @Column(length = 100, nullable = false, unique = true)
    private String email;
    @Column(length = 15, nullable = false)
    private String telefone;
}
