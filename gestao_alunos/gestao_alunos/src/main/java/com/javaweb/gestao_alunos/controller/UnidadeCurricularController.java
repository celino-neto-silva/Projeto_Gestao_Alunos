package com.javaweb.gestao_alunos.controller;

import com.javaweb.gestao_alunos.models.UnidadeCurricular;
import com.javaweb.gestao_alunos.repository.UnidadeCurricularRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/unidadescurriculares")
public class UnidadeCurricularController {
    private final UnidadeCurricularRepository unidadeCurricularRepository;

    public UnidadeCurricularController(UnidadeCurricularRepository unidadeCurricularRepository) {
        this.unidadeCurricularRepository = unidadeCurricularRepository;
    }

    @GetMapping
    public String listarUnidadeCurricular(Model model){
        List<UnidadeCurricular> unidadescurriculares = unidadeCurricularRepository.findAll();
        model.addAttribute("unidadescurriculares", unidadescurriculares);
        model.addAttribute("novaUnidadeCurricular", new UnidadeCurricular());
        return "unidadescurriculares";
    }

    @PostMapping
    public String criarUnidadeCurricular(@ModelAttribute("novaUnidadeCurricular") UnidadeCurricular novaUnidadeCurricular){
        if(novaUnidadeCurricular.getNome() != null && !novaUnidadeCurricular.getNome().isBlank()){
            unidadeCurricularRepository.save(novaUnidadeCurricular);
        }
        return "redirect:/unidadescurriculares";
    }

    @PostMapping("/remover")
    public String removerUnidadeCurricular(@RequestParam("id") Long id){
        unidadeCurricularRepository.deleteById(id);
        return "redirect:/unidadescurriculares";
    }
}
