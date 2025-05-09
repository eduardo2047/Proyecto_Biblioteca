package com.biblioteca.cl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.biblioteca.cl.model.Prestamo; 
import com.biblioteca.cl.service.PrestamoService;

import java.util.List;

@RestController
@RequestMapping("/api/v4/prestamos")
public class PrestamoController {
    @Autowired
    private PrestamoService prestamoService;

    @GetMapping
    public ResponseEntity<List<Prestamo>> listarPrestamos() {
        List<Prestamo> prestamos = prestamoService.findAll();
        if (prestamos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(prestamos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> obtenerPrestamosPorId(@PathVariable Integer id) {
        Prestamo prestamo = prestamoService.findById(id);
        if (prestamo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(prestamo);
    }

    @PostMapping
    public ResponseEntity<Prestamo> agregarPrestamo(@RequestBody Prestamo prestamo) {
        Prestamo nuevoPrestamo = prestamoService.save(prestamo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPrestamo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prestamo> actualizarPrestamo(@PathVariable Integer id, @RequestBody Prestamo prestamo) {
        Prestamo existente = prestamoService.findById(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        prestamo.setId(id);
        Prestamo actualizado = prestamoService.save(prestamo);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPrestamo(@PathVariable Integer id) {
        Prestamo existente = prestamoService.findById(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        prestamoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
