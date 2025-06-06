package com.aguacatech.service.impl;

import com.aguacatech.model.Producto;
import com.aguacatech.repository.ProductoRepository;
import com.aguacatech.service.ProductoService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findById(Integer id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void deleteById(Integer id) {
        productoRepository.deleteById(id);
    }

    @Override
    public List<Object[]> contarProductosPorTipo() {
        return productoRepository.contarProductosPorTipo();
    }

}
