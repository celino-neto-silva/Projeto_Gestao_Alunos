package com.javaweb.gestao_alunos.controller;

import com.javaweb.gestao_alunos.models.*;
import com.javaweb.gestao_alunos.repository.AlunoRepository;
import com.javaweb.gestao_alunos.repository.EdicaoRepository;
import com.javaweb.gestao_alunos.repository.MatriculaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {
    private final MatriculaRepository matriculaRepository;
    private final AlunoRepository alunoRepository;
    private final EdicaoRepository edicaoRepository;

    public MatriculaController(MatriculaRepository matriculaRepository, AlunoRepository alunoRepository, EdicaoRepository edicaoRepository) {
        this.matriculaRepository = matriculaRepository;
        this.alunoRepository = alunoRepository;
        this.edicaoRepository = edicaoRepository;
    }

    @GetMapping
    public String listarMatriculas(Model model){
        List<Matricula> matriculas = matriculaRepository.findAll();
        List<Aluno> alunos = alunoRepository.findAll();
        List<Edicao> edicoes = edicaoRepository.findAll();

        model.addAttribute("matriculas", matriculas);
        model.addAttribute("alunos", alunos);
        model.addAttribute("edicoes", edicoes);

        return "matriculas";
    }

    @PostMapping
    public String criarMatricula(@RequestParam("alunoId") Long alunoId,
                              @RequestParam("edicaoId") Long edicaoId){

        Aluno aluno = alunoRepository.findById(alunoId).orElse(null);
        Edicao edicao = edicaoRepository.findById(edicaoId).orElse(null);

        if (aluno == null || edicao == null) {
            return "redirect:/matriculas";
        }

        Matricula matricula = new Matricula();
        matricula.setAluno(aluno);
        matricula.setEdicao(edicao);
        matriculaRepository.save(matricula);

        return "redirect:/matriculas";
    }

    @PostMapping("/remover")
    public String removerMatricula(@RequestParam("id") Long id){
        matriculaRepository.deleteById(id);
        return "redirect:/matriculas";
    }
}
