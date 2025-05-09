package com.biblioteca.cl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.cl.model.Libro;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {
    // Encuentra productos por nombre
    List<Libro> findByNombre(String nombre);
    
    // Encuentra productos por categoría
    List<Libro> findByCategoria(String categoria);
    
    // Encuentra productos con stock menor a un valor
    List<Libro> findByStockLessThan(int stock);
    
    // Encuentra productos con precio menor a un valor
    List<Libro> findByPrecioLessThan(double precio);
}
