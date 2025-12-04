package com.Kartconnecting.Backend.controller;

import com.Kartconnecting.Backend.model.User;
import com.Kartconnecting.Backend.security.JwtUtil;
import com.Kartconnecting.Backend.security.LoginRequest;
import com.Kartconnecting.Backend.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;

    public AuthController(AuthService authService, JwtUtil jwtUtil) {
        this.authService = authService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        User user = authService.login(request.getEmail(), request.getPassword());

        if (user == null) {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }

        String token = jwtUtil.generarToken(user.getEmail());

        return ResponseEntity.ok().body(token);
    }
}

