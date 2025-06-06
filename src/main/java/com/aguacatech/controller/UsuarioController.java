package com.aguacatech.controller;

import com.aguacatech.model.Usuario;
import com.aguacatech.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.findAll());
        return "usuarios/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/formulario";
    }

    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{id}")
    public String editarUsuario(@PathVariable Integer id, Model model) {
        Usuario usuario = usuarioService.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("usuario", usuario);
        return "usuarios/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Integer id) {
        usuarioService.deleteById(id);
        return "redirect:/usuarios";
    }
}
