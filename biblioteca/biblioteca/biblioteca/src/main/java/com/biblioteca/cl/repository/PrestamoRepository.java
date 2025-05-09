package com.biblioteca.cl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.cl.model.Prestamo;

import java.util.List;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {
    // Encuentra pedidos por clienteId
    List<Prestamo> findByClienteId(Integer clienteId);
    
    // Encuentra pedidos por estado
    List<Prestamo> findByEstado(String estado);
    
    // Encuentra pedidos por fecha de creación
    List<Prestamo> findByFechaCreacion(String fechaCreacion);
}
