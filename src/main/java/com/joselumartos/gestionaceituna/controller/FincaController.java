package com.joselumartos.gestionaceituna.controller;

import com.joselumartos.gestionaceituna.dto.FincaDto;
import com.joselumartos.gestionaceituna.repository.ParteRecogidaRepository;
import com.joselumartos.gestionaceituna.service.FincaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fincas")
public class FincaController {
    private final FincaService service;
    private final ParteRecogidaRepository parteRepo; // Para la consulta de producción

    public FincaController(FincaService service, ParteRecogidaRepository parteRepo) {
        this.service = service;
        this.parteRepo = parteRepo;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("fincas", service.listar());
        return "finca/lista";
    }

    // Consulta avanzada: Producción total [cite: 565]
    @GetMapping("/{id}/produccion")
    public String verProduccion(@PathVariable Long id, Model model) {
        FincaDto finca = service.buscarPorId(id);
        double total = parteRepo.getProduccionTotalByFinca(finca.nombre());
        model.addAttribute("finca", finca);
        model.addAttribute("totalProduccion", total);
        return "finca/produccion";
    }
}
