package com.backend.estudiantes.utils;

import com.backend.estudiantes.model.Usuario;

import java.util.HashMap;
import java.util.Map;

public class AuthReponseBuilder {

    public static Map<String, Object> buildAuthResponse (String token, Usuario usuario){
        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("usuario", build(usuario));

        return response;
    };

    private static Map<String, Object> build(Usuario usuario){
        Map<String, Object> usuarioResponse = new HashMap<>();
        usuarioResponse.put("id", usuario.getId());
        usuarioResponse.put("nombre", usuario.getNombre());
        usuarioResponse.put("apellido", usuario.getApellido());
        usuarioResponse.put("email", usuario.getEmail());
        usuarioResponse.put("rol", usuario.getRol());
        return usuarioResponse;
    }
}
