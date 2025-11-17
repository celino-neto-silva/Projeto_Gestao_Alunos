package com.javaweb.gestao_alunos.controller;

import com.javaweb.gestao_alunos.models.Aluno;
import com.javaweb.gestao_alunos.repository.AlunoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AlunoController {
    private final List<Aluno> alunos = new ArrayList<>();
    private final AlunoRepository repository;

    public AlunoController(AlunoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String paginaInicial(){
        return "redirect:/alunos";
    }

    @GetMapping("/alunos")
    public String listarAlunos(Model model){
        List<Aluno> alunos=repository.findAll();
        model.addAttribute("alunos", alunos);
        model.addAttribute("novoAluno", new Aluno());
        return "alunos";
    }

    @PostMapping("/alunos")
    public String adicionarAluno(@ModelAttribute("novoAluno") Aluno novoAluno){
        if(novoAluno.getNome() != null && !novoAluno.getNome().isBlank()){
            repository.save(novoAluno);
        }
        return "redirect:/alunos";
    }

    @PostMapping("/alunos/remover")
    public String removerAluno(@RequestParam("id") Long id){
        repository.deleteById(id);
        return "redirect:/alunos";
    }
}
