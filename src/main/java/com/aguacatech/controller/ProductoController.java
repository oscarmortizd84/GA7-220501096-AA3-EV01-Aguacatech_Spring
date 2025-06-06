package com.aguacatech.controller;

import com.aguacatech.model.Producto;
import com.aguacatech.service.ProductoService;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;




@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public String listarProductos(Model model) {
        model.addAttribute("productos", productoService.findAll());
        return "productos/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("producto", new Producto());
        return "productos/formulario";
    }

    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute("producto") Producto producto) {
        productoService.save(producto);
        return "redirect:/productos";
    }

    @GetMapping("/editar/{id}")
    public String editarProducto(@PathVariable Integer id, Model model) {
        Producto producto = productoService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("producto", producto);
        return "productos/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Integer id) {
        productoService.deleteById(id);
        return "redirect:/productos";
    }

    @GetMapping("/grafico")
    public String mostrarGrafico(Model model) {
        List<Object[]> datos = productoService.contarProductosPorTipo();

        List<String> tipos = new ArrayList<>();
        List<Long> cantidades = new ArrayList<>();

        for (Object[] fila : datos) {
            tipos.add((String) fila[0]);
            cantidades.add((Long) fila[1]);
        }

        model.addAttribute("tipos", tipos);
        model.addAttribute("cantidades", cantidades);

        return "productos/grafico";
    }


    

}
