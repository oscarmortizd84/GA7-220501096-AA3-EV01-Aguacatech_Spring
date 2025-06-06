package com.aguacatech.service;

import com.aguacatech.model.Producto;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProductoService {
    List<Producto> findAll();
    Optional<Producto> findById(Integer id);
    Producto save(Producto producto);
    void deleteById(Integer id);

    List<Object[]> contarProductosPorTipo();
}
