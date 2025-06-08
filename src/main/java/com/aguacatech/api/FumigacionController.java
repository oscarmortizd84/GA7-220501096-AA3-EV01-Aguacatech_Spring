package com.aguacatech.api;

import com.aguacatech.model.Fumigacion;
import com.aguacatech.service.FumigacionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fumigaciones")
public class FumigacionController {

    private final FumigacionService service;

    public FumigacionController(FumigacionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Fumigacion> getAll() {
        return service.findAll();
    }

    @PostMapping
    public Fumigacion create(@RequestBody Fumigacion fumigacion) {
        return service.save(fumigacion);
    }

    @PutMapping("/{id}")
    public Fumigacion update(@PathVariable Integer id, @RequestBody Fumigacion fumigacion) {
        fumigacion.setId(id);
        return service.save(fumigacion);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteById(id);
    }
}
