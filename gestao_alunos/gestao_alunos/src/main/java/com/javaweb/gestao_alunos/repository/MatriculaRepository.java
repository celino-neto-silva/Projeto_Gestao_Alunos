package com.javaweb.gestao_alunos.repository;

import com.javaweb.gestao_alunos.models.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}
