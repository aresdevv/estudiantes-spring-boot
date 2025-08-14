package com.backend.estudiantes.controller;

import com.backend.estudiantes.dto.LoginRequest;
import com.backend.estudiantes.model.Usuario;
import com.backend.estudiantes.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest){

        try{
            Usuario usuario = authService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());
            return ResponseEntity.ok(Map.of(
                    "message", "Login exitoso",
                    "email", usuario.getEmail(),
                    "rol", usuario.getRol()
            ));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(Map.of(
                    "error", e.getMessage()
            ));
        }


    }
}
