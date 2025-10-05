package com.example.ferramentas.controller;

import com.example.ferramentas.model.Ferramenta;
import com.example.ferramentas.repository.FerramentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ferramentas")
public class FerramentaController {

    @Autowired
    private FerramentaRepository ferramentaRepository;

    @GetMapping
    public String listFerramentas(Model model) {
        model.addAttribute("ferramentas", ferramentaRepository.findAll());
        return "ferramentas";
    }

    @GetMapping("/new")
    public String showFerramentaForm(Model model) {
        model.addAttribute("ferramenta", new Ferramenta());
        return "ferramenta-form";
    }

    @PostMapping
    public String saveFerramenta(@ModelAttribute Ferramenta ferramenta) {
        ferramentaRepository.save(ferramenta);
        return "redirect:/ferramentas";
    }

    @GetMapping("/edit/{id}")
    public String showEditFerramentaForm(@PathVariable Long id, Model model) {
        Ferramenta ferramenta = ferramentaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid ferramenta Id:" + id));
        model.addAttribute("ferramenta", ferramenta);
        return "ferramenta-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteFerramenta(@PathVariable Long id) {
        ferramentaRepository.deleteById(id);
        return "redirect:/ferramentas";
    }
}

