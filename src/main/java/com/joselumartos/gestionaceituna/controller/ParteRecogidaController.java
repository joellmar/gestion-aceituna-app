package com.joselumartos.gestionaceituna.controller;

import com.joselumartos.gestionaceituna.dto.ParteRecogidaDto;
import com.joselumartos.gestionaceituna.repository.CuadrillaRepository;
import com.joselumartos.gestionaceituna.service.AlmazaraService;
import com.joselumartos.gestionaceituna.service.FincaService;
import com.joselumartos.gestionaceituna.service.ParteRecogidaService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/partes")
public class ParteRecogidaController {
    private final ParteRecogidaService service;
    private final FincaService fincaService;
    private final AlmazaraService almazaraService;
    private final CuadrillaRepository cuadrillaRepo; // Necesitas los datos para los select del form

    public ParteRecogidaController(ParteRecogidaService service, FincaService fincaService,
                                   AlmazaraService almazaraService, CuadrillaRepository cuadrillaRepo) {
        this.service = service;
        this.fincaService = fincaService;
        this.almazaraService = almazaraService;
        this.cuadrillaRepo = cuadrillaRepo;
    }

    @GetMapping("/nuevo")
    public String nuevoParte(Model model) {
        model.addAttribute("parte", new ParteRecogidaDto(null, LocalDate.now(), 0.0, 0.0, "", null, "", null, "", null, ""));
        model.addAttribute("fincas", fincaService.listar());
        model.addAttribute("almazaras", almazaraService.listar(Pageable.unpaged()).getContent());
        model.addAttribute("cuadrillas", cuadrillaRepo.findAll());
        return "parte/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute("parte") ParteRecogidaDto dto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // Recargar listas si hay error [cite: 890]
            model.addAttribute("fincas", fincaService.listar());
            return "parte/formulario";
        }
        service.guardar(dto);
        return "redirect:/partes";
    }
}
