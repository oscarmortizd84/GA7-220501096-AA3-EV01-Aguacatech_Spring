package com.aguacatech.service;

import com.aguacatech.model.Riego;

import java.util.List;
import java.util.Optional;

public interface RiegoService {
    List<Riego> findAll();
    Optional<Riego> findById(Integer id);
    Riego save(Riego riego);
    void deleteById(Integer id);
}
