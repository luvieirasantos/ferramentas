package com.example.ferramentas.controller;

import com.example.ferramentas.model.Ferramenta;
import com.example.ferramentas.repository.FerramentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('ADMIN')")
    public String showFerramentaForm(Model model) {
        model.addAttribute("ferramenta", new Ferramenta());
        return "ferramenta-form";
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String saveFerramenta(@ModelAttribute Ferramenta ferramenta) {
        ferramentaRepository.save(ferramenta);
        return "redirect:/ferramentas";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String showEditFerramentaForm(@PathVariable Long id, Model model) {
        Ferramenta ferramenta = ferramentaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid ferramenta Id:" + id));
        model.addAttribute("ferramenta", ferramenta);
        return "ferramenta-form";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteFerramenta(@PathVariable Long id) {
        ferramentaRepository.deleteById(id);
        return "redirect:/ferramentas";
    }
}

