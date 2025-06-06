package com.aguacatech.service;

import com.aguacatech.model.Lote;

import java.util.List;
import java.util.Optional;

public interface LoteService {
    List<Lote> findAll();
    Optional<Lote> findById(Integer id);
    Lote save(Lote lote);
    void deleteById(Integer id);
}
