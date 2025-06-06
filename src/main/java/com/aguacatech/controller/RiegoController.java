package com.aguacatech.controller;

import com.aguacatech.model.Riego;
import com.aguacatech.service.LoteService;
import com.aguacatech.service.RiegoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/riegos")
public class RiegoController {

    private final RiegoService riegoService;
    private final LoteService loteService;

    public RiegoController(RiegoService riegoService, LoteService loteService) {
        this.riegoService = riegoService;
        this.loteService = loteService;
    }

    @GetMapping
    public String listarRiegos(Model model) {
        model.addAttribute("riegos", riegoService.findAll());
        return "riegos/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("riego", new Riego());
        model.addAttribute("lotes", loteService.findAll()); // para el combo de lotes
        return "riegos/formulario";
    }

    @PostMapping("/guardar")
    public String guardarRiego(@ModelAttribute("riego") Riego riego) {
        riegoService.save(riego);
        return "redirect:/riegos";
    }

    @GetMapping("/editar/{id}")
    public String editarRiego(@PathVariable Integer id, Model model) {
        Riego riego = riegoService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("riego", riego);
        model.addAttribute("lotes", loteService.findAll());
        return "riegos/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarRiego(@PathVariable Integer id) {
        riegoService.deleteById(id);
        return "redirect:/riegos";
    }
}
