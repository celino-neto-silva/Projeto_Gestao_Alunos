package com.javaweb.gestao_alunos.repository;

import com.javaweb.gestao_alunos.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
