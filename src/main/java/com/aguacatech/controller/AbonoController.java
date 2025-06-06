package com.aguacatech.controller;

import com.aguacatech.model.Abono;
import com.aguacatech.model.Lote;
import com.aguacatech.model.Producto;
import com.aguacatech.service.AbonoService;
import com.aguacatech.service.LoteService;
import com.aguacatech.service.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/abonos")
public class AbonoController {

    private final AbonoService abonoService;
    private final ProductoService productoService;
    private final LoteService loteService;

    public AbonoController(AbonoService abonoService, ProductoService productoService, LoteService loteService) {
        this.abonoService = abonoService;
        this.productoService = productoService;
        this.loteService = loteService;
    }

    @GetMapping
    public String listarAbonos(Model model) {
        model.addAttribute("abonos", abonoService.findAll());
        return "abonos/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("abono", new Abono());
        model.addAttribute("productos", productoService.findAll());
        model.addAttribute("lotes", loteService.findAll());
        return "abonos/formulario";
    }

    @PostMapping("/guardar")
    public String guardarAbono(@ModelAttribute("abono") Abono abono) {
        Producto producto = productoService.findById(abono.getProducto().getId()).orElse(null);
        Lote lote = loteService.findById(abono.getLote().getId()).orElse(null);

        abono.setProducto(producto);
        abono.setLote(lote);

        abonoService.save(abono);
        return "redirect:/abonos";
    }

    @GetMapping("/editar/{id}")
    public String editarAbono(@PathVariable Integer id, Model model) {
        Abono abono = abonoService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));

        model.addAttribute("abono", abono);
        model.addAttribute("productos", productoService.findAll());
        model.addAttribute("lotes", loteService.findAll());
        return "abonos/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarAbono(@PathVariable Integer id) {
        abonoService.deleteById(id);
        return "redirect:/abonos";
    }
}
