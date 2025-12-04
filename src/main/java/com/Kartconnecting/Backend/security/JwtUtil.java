package com.Kartconnecting.Backend.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private static final String SECRET = "12345678901234567890123456789012";
    private static final long EXPIRATION = 1000 * 60 * 60;

    public String generarToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()))
                .compact();
    }

    public boolean validarToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(SECRET.getBytes()))
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String obtenerEmail(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(SECRET.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // ==== WRAPPERS PARA COINCIDIR CON TU AuthServiceImpl ====

    // Si en AuthServiceImpl llamas jwtUtil.generateToken(...)
    public String generateToken(String email) {
        return generarToken(email);
    }

    // Si en JwtFilter o en otra parte usas validateToken(...)
    public boolean validateToken(String token) {
        return validarToken(token);
    }

    // Si en algún lado usas extractUsername(...)
    public String extractUsername(String token) {
        return obtenerEmail(token);
    }
}

