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
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<UnidadeCurricular> unidadescurriculares;

    @ManyToOne
    @JoinColumn(name = "edicao_id")
    private Edicao edicao;
}
