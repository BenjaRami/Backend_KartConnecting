package com.Kartconnecting.Backend.security;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtFilter implements Filter {

    private final JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String path = req.getRequestURI();

        // --- RUTAS PÚBLICAS ---
        if (
                path.startsWith("/api/auth") ||     // login / register
                path.startsWith("/swagger-ui") ||   // swagger UI
                path.startsWith("/v3/api-docs") ||  // openapi docs
                path.equals("/swagger-ui.html")
        ) {
            chain.doFilter(request, response);
            return;
        }

        // --- HEADER AUTHORIZATION ---
        String authHeader = req.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            res.getWriter().write("Falta token");
            return;
        }

        String token = authHeader.substring(7);

        // --- VALIDACIÓN DEL TOKEN ---
        if (!jwtUtil.validateToken(token)) {
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            res.getWriter().write("Token inválido");
            return;
        }

        // Si el token es válido, continuar
        chain.doFilter(request, response);
    }
}




