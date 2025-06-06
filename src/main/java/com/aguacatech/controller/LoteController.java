package com.aguacatech.controller;

import com.aguacatech.model.Lote;
import com.aguacatech.service.LoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/lotes")
public class LoteController {

    private final LoteService loteService;

    public LoteController(LoteService loteService) {
        this.loteService = loteService;
    }

    @GetMapping
    public String listarLotes(Model model) {
        model.addAttribute("lotes", loteService.findAll());
        return "lotes/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("lote", new Lote());
        return "lotes/formulario";
    }

    @PostMapping("/guardar")
    public String guardarLote(@ModelAttribute("lote") Lote lote) {
        loteService.save(lote);
        return "redirect:/lotes";
    }

    @GetMapping("/editar/{id}")
    public String editarLote(@PathVariable Integer id, Model model) {
        Lote lote = loteService.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("lote", lote);
        return "lotes/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarLote(@PathVariable Integer id) {
        loteService.deleteById(id);
        return "redirect:/lotes";
    }
}
