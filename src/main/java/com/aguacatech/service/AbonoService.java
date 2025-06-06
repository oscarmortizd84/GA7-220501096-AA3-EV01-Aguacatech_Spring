package com.aguacatech.service;

import com.aguacatech.model.Abono;

import java.util.List;
import java.util.Optional;

public interface AbonoService {
    List<Abono> findAll();
    Optional<Abono> findById(Integer id);
    Abono save(Abono abono);
    void deleteById(Integer id);
}
