package com.joselumartos.gestionaceituna.controller;

import com.joselumartos.gestionaceituna.dto.AlmazaraDto;
import com.joselumartos.gestionaceituna.service.AlmazaraService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/almazaras")
public class AlmazaraController {
    private final AlmazaraService service;

    public AlmazaraController(AlmazaraService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model, Pageable pageable) {
        model.addAttribute("almazaras", service.listar(pageable));
        return "almazara/lista";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute("almazara") AlmazaraDto dto, BindingResult result) {
        if (result.hasErrors()) return "almazara/formulario";
        service.guardar(dto);
        return "redirect:/almazaras";
    }
}