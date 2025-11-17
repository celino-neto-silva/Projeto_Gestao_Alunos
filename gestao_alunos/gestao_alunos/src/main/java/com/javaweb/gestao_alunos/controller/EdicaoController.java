package com.javaweb.gestao_alunos.controller;

import com.javaweb.gestao_alunos.models.Curso;
import com.javaweb.gestao_alunos.models.Edicao;
import com.javaweb.gestao_alunos.models.UnidadeCurricular;
import com.javaweb.gestao_alunos.repository.CursoRepository;
import com.javaweb.gestao_alunos.repository.EdicaoRepository;
import com.javaweb.gestao_alunos.repository.UnidadeCurricularRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/edicoes")
public class EdicaoController {
    private final EdicaoRepository edicaoRepository;
    private final CursoRepository cursoRepository;
    private final UnidadeCurricularRepository unidadeCurricularRepository;

    public EdicaoController(EdicaoRepository edicaoRepository, CursoRepository cursoRepository, UnidadeCurricularRepository unidadeCurricularRepository) {
        this.edicaoRepository = edicaoRepository;
        this.cursoRepository = cursoRepository;
        this.unidadeCurricularRepository = unidadeCurricularRepository;
    }

    @GetMapping
    public String listarEdicoes(Model model){
        List<Edicao> edicoes = edicaoRepository.findAll();
        List<Curso> cursos = cursoRepository.findAll();
        List<UnidadeCurricular> unidadescurriculares = unidadeCurricularRepository.findAll();

        model.addAttribute("edicoes", edicoes);
        model.addAttribute("unidadescurriculares", unidadescurriculares);
        model.addAttribute("cursos", cursos);

        return "edicoes";
    }

    @PostMapping
    public String criarEdicao(@RequestParam("cursoId") Long cursoId,
                              @RequestParam("unidadecurricularId") Long unidadecurricularId,
                              @RequestParam String descricao) {

        Curso curso = cursoRepository.findById(cursoId).orElse(null);
        UnidadeCurricular uc = unidadeCurricularRepository.findById(unidadecurricularId).orElse(null);

        if (curso == null || uc == null) {
            return "redirect:/edicoes";
        }

        Edicao edicao = new Edicao();
        edicao.setDescricao(descricao);
        edicao.setCurso(curso);
        edicao.setUnidadecurricular(uc);

        edicaoRepository.save(edicao);

        return "redirect:/edicoes";
    }

    @PostMapping("/remover")
    public String removerEdicao(@RequestParam("id") Long id){
        edicaoRepository.deleteById(id);
        return "redirect:/edicoes";
    }
}

