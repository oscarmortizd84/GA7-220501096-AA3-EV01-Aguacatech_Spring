package com.aguacatech.api;

import com.aguacatech.model.Riego;
import com.aguacatech.service.RiegoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/riegos")
public class RiegoController {

    private final RiegoService service;

    public RiegoController(RiegoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Riego> getAll() {
        return service.findAll();
    }

    @PostMapping
    public Riego create(@RequestBody Riego riego) {
        return service.save(riego);
    }

    @PutMapping("/{id}")
    public Riego update(@PathVariable Integer id, @RequestBody Riego riego) {
        riego.setId(id);
        return service.save(riego);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteById(id);
    }
}
