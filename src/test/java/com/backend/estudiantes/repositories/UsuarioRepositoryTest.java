package com.backend.estudiantes.repositories;

import com.backend.estudiantes.model.Role;
import com.backend.estudiantes.model.Usuario;
import com.backend.estudiantes.repository.UsuarioRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Test
    void findByEmailTest_UsuarioExistente_RetornaUsuario() {
        Usuario testUser = new Usuario(
                "test",
                "User",
                "test@unmsm.edu.pe",
                "123",
                Role.Estudiante
        );

        Usuario guardado = usuarioRepository.save(testUser);

        Optional<Usuario> encontradoOptional = usuarioRepository.findByEmail(guardado.getEmail());

        assertTrue(encontradoOptional.isPresent(),"Usuario deberia exisitir en la BD");

        Usuario encontrado = encontradoOptional.get();

        assertEquals("test@unmsm.edu.pe", encontrado.getEmail(),
                "El email del usuario encontrado no coincide con el esperado");



    }

}
