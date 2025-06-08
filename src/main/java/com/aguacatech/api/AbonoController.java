package com.aguacatech.api;

import com.aguacatech.model.Abono;
import com.aguacatech.service.AbonoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/abonos")
public class AbonoController {

    private final AbonoService abonoService;

    public AbonoController(AbonoService abonoService) {
        this.abonoService = abonoService;
    }

    @GetMapping
    public List<Abono> getAll() {
        return abonoService.findAll();
    }

    @PostMapping
    public Abono create(@RequestBody Abono abono) {
        return abonoService.save(abono);
    }

    @PutMapping("/{id}")
    public Abono update(@PathVariable Integer id, @RequestBody Abono abono) {
        abono.setId(id);
        return abonoService.save(abono);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        abonoService.deleteById(id);
    }
}
