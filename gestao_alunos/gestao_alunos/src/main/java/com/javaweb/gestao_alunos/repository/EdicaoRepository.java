package com.javaweb.gestao_alunos.repository;

import com.javaweb.gestao_alunos.models.Edicao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EdicaoRepository extends JpaRepository<Edicao, Long> {
}
