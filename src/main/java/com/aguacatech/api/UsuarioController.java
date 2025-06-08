package com.aguacatech.api;

import com.aguacatech.model.Usuario;
import com.aguacatech.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Usuario> getAll() {
        return service.findAll();
    }

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
        return service.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario update(@PathVariable Integer id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        return service.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteById(id);
    }
}
