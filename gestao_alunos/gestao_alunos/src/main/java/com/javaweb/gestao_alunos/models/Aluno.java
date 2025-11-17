package com.javaweb.gestao_alunos.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private int idade;

    @OneToOne(mappedBy = "aluno", cascade = CascadeType.ALL)
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "matricula_id")
    private Matricula matricula;
}
