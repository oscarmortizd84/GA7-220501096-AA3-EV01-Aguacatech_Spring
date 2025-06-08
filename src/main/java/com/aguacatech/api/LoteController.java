package com.aguacatech.api;

import com.aguacatech.model.Lote;
import com.aguacatech.service.LoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lotes")
public class LoteController {

    private final LoteService loteService;

    public LoteController(LoteService loteService) {
        this.loteService = loteService;
    }

    @GetMapping
    public List<Lote> getAll() {
        return loteService.findAll();
    }

    @PostMapping
    public Lote create(@RequestBody Lote lote) {
        return loteService.save(lote);
    }

    @PutMapping("/{id}")
    public Lote update(@PathVariable Integer id, @RequestBody Lote lote) {
        lote.setId(id);
        return loteService.save(lote);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        loteService.deleteById(id);
    }
}
