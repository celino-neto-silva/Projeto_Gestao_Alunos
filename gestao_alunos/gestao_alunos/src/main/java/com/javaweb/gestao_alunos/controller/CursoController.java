package com.javaweb.gestao_alunos.controller;

import com.javaweb.gestao_alunos.models.Curso;
import com.javaweb.gestao_alunos.repository.CursoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cursos")
public class CursoController {
    private final CursoRepository repository;

    public CursoController(CursoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String listarCurso(Model model){
        List<Curso> cursos = repository.findAll();
        model.addAttribute("cursos", cursos);
        model.addAttribute("novoCurso", new Curso());
        return "cursos";
    }

    @PostMapping
    public String criarCurso(@ModelAttribute("novoCurso") Curso novoCurso){
        if(novoCurso.getNome() != null && !novoCurso.getNome().isBlank()){
            repository.save(novoCurso);
        }
        return "redirect:/cursos";
    }

    @PostMapping("/remover")
    public String removerCurso(@RequestParam("id") Long id){
        repository.deleteById(id);
        return "redirect:/cursos";
    }
}
