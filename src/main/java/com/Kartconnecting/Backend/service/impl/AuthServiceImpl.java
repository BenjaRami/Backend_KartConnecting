package com.Kartconnecting.Backend.service.impl;

import com.Kartconnecting.Backend.model.User;
import com.Kartconnecting.Backend.repository.UserRepository;
import com.Kartconnecting.Backend.security.JwtUtil;
import com.Kartconnecting.Backend.security.LoginRequest;
import com.Kartconnecting.Backend.service.AuthService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(UserRepository repo, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public User register(User usuario) {

        // validar correo
        repo.findByEmail(usuario.getEmail()).ifPresent(u -> {
            throw new RuntimeException("El correo ya está registrado");
        });

        // encriptar contraseña
        String passEncriptada = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(passEncriptada);

        return repo.save(usuario);
    }

    @Override
    public String login(LoginRequest request) {

        User usuario = repo.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // validar contraseña
        if (!passwordEncoder.matches(request.getPassword(), usuario.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        // generar token
        return jwtUtil.generateToken(usuario.getEmail());
    }
}

