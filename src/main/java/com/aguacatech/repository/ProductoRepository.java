package com.aguacatech.repository;

import com.aguacatech.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    @Query("SELECT p.tipo, COUNT(p) FROM Producto p GROUP BY p.tipo")
    List<Object[]> contarProductosPorTipo();


}
