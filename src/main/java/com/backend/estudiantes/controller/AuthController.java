package com.backend.estudiantes.controller;

import com.backend.estudiantes.dto.LoginRequest;
import com.backend.estudiantes.model.Usuario;
import com.backend.estudiantes.service.AuthService;
import com.backend.estudiantes.service.JwtService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    private final JwtService jwtService;

    public AuthController(AuthService authService, JwtService jwtService) {
        this.authService = authService;
        this.jwtService = jwtService;

    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest){

        try{
            Usuario usuario = authService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());

            Map<String, Object> extraClaims = new HashMap<>();
            extraClaims.put("rol", usuario.getRol());
            extraClaims.put("nombre", usuario.getNombre());
            extraClaims.put("email", usuario.getEmail());

            String jwtToken = jwtService.generateToken(extraClaims, usuario);

            return ResponseEntity.ok(Map.of(
                    "message", "Login exitoso",
                    "expiresIn", jwtService.getJwtExpirationMs(),
                    "token", jwtToken,
                    "data", Map.of(
                            "email", usuario.getEmail(),
                            "rol", usuario.getRol()
                    )
            ));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of(
                    "Error", "Credenciales incorrectas"
            ));

        }


    }
}
