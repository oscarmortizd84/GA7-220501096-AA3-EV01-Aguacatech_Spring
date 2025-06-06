package com.aguacatech.controller;

import com.aguacatech.model.Fumigacion;
import com.aguacatech.model.Lote;
import com.aguacatech.model.Producto;
import com.aguacatech.service.FumigacionService;
import com.aguacatech.service.LoteService;
import com.aguacatech.service.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/fumigaciones")
public class FumigacionController {

    private final FumigacionService fumigacionService;
    private final ProductoService productoService;
    private final LoteService loteService;

    public FumigacionController(FumigacionService fumigacionService, ProductoService productoService, LoteService loteService) {
        this.fumigacionService = fumigacionService;
        this.productoService = productoService;
        this.loteService = loteService;
    }

    @GetMapping
    public String listarFumigaciones(Model model) {
        model.addAttribute("fumigaciones", fumigacionService.findAll());
        return "fumigaciones/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("fumigacion", new Fumigacion());
        model.addAttribute("productos", productoService.findAll());
        model.addAttribute("lotes", loteService.findAll());
        return "fumigaciones/formulario";
    }

    @PostMapping("/guardar")
    public String guardarFumigacion(@ModelAttribute("fumigacion") Fumigacion fumigacion) {
        Producto producto = productoService.findById(fumigacion.getProducto().getId()).orElse(null);
        Lote lote = loteService.findById(fumigacion.getLote().getId()).orElse(null);
        fumigacion.setProducto(producto);
        fumigacion.setLote(lote);

        fumigacionService.save(fumigacion);
        return "redirect:/fumigaciones";
    }

    @GetMapping("/editar/{id}")
    public String editarFumigacion(@PathVariable Integer id, Model model) {
        Fumigacion fumigacion = fumigacionService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));

        model.addAttribute("fumigacion", fumigacion);
        model.addAttribute("productos", productoService.findAll());
        model.addAttribute("lotes", loteService.findAll());
        return "fumigaciones/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarFumigacion(@PathVariable Integer id) {
        fumigacionService.deleteById(id);
        return "redirect:/fumigaciones";
    }
}
