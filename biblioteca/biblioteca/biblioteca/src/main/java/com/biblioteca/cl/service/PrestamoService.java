package com.biblioteca.cl.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.cl.model.Prestamo;
import com.biblioteca.cl.repository.PrestamoRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    public List<Prestamo> findAll() {
        return prestamoRepository.findAll();
    }

    public Prestamo findById(Integer id) {
        Optional<Prestamo> prestamo = prestamoRepository.findById(id);
        return prestamo.orElse(null);
    }

    public Prestamo save(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    public void delete(Integer id) {
        prestamoRepository.deleteById(id);
    }
}