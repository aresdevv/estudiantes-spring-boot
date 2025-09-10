package com.backend.estudiantes.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Base64;

@Service
public class JwtService {

    @Value("${app.jwt.secret}")
    private String secretKey;

    @Value("${app.jwt.expirationMs}")
    private Long jwtExpirationMs;

    private Key getSignInKey(){
        byte [] KeyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(KeyBytes);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parser()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
