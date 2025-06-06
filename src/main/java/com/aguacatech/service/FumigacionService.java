package com.aguacatech.service;

import com.aguacatech.model.Fumigacion;

import java.util.List;
import java.util.Optional;

public interface FumigacionService {
    List<Fumigacion> findAll();
    Optional<Fumigacion> findById(Integer id);
    Fumigacion save(Fumigacion fumigacion);
    void deleteById(Integer id);
}
