package com.backend.estudiantes.service;

import com.backend.estudiantes.model.Role;
import com.backend.estudiantes.model.Usuario;
import com.backend.estudiantes.repository.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Data {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
//        Usuario admin = new Usuario();
//        admin.setEmail("giovanni.arias@unmsm.edu.pe");
//        admin.setPassword(passwordEncoder.encode("Dvanlm2020"));
//        admin.setRol(Role.ADMIN);
//        admin.setNombre("Giovanni");
//        admin.setApellido("Arias");
//        usuarioRepository.save(admin);
    }
}
