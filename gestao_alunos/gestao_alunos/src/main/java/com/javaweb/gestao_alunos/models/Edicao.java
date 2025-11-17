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
public class Edicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

    @ManyToOne
    private Curso curso;

    @ManyToOne
    private UnidadeCurricular unidadecurricular;

    @ManyToOne
    @JoinColumn(name = "matricula_id")
    private Matricula matricula;
}
