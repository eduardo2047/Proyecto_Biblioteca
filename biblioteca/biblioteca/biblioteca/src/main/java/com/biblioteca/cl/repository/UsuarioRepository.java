package com.biblioteca.cl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.cl.model.Usuario;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Encuentra usuario por correo
    Usuario findByCorreo(String correo);
    
    // Encuentra usuarios por rol
    List<Usuario> findByRol(String rol);
    
    // Encuentra usuarios por nombre
    List<Usuario> findByNombre(String nombre);
}
