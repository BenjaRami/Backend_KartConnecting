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

        System.out.println(">>> EMAIL RECIBIDO = '" + usuario.getEmail() + "'");
    System.out.println(">>> PASSWORD RECIBIDO = '" + usuario.getPassword() + "'");
    System.out.println(">>> NAME RECIBIDO = '" + usuario.getName() + "'");

    if (usuario.getEmail() == null || usuario.getEmail().trim().isEmpty()) {
        throw new RuntimeException("Email vacío");
    }

    String emailLimpio = usuario.getEmail().trim().toLowerCase();
    usuario.setEmail(emailLimpio);

    // Validación de correo único
    System.out.println(">>> BUSCANDO EMAIL EN BD...");
    if (repo.findByEmail(emailLimpio).isPresent()) {
        throw new RuntimeException("El correo ya está registrado");
    }

    // Encriptación
    System.out.println(">>> ENCRIPTANDO PASSWORD...");
    usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

    // Guardar usuario
    System.out.println(">>> GUARDANDO USUARIO...");
    User saved = repo.save(usuario);

    System.out.println(">>> USUARIO GUARDADO CON ID = " + saved.getId());
    return saved;
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

