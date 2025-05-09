package com.biblioteca.cl.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.cl.model.Libro;
import com.biblioteca.cl.repository.LibroRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    public Libro findById(Integer id) {
        Optional<Libro> libro = libroRepository.findById(id);
        return libro.orElse(null);
    }

    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }

    public void delete(Integer id) {
        libroRepository.deleteById(id);
    }
}
