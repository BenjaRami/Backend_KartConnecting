package com.Kartconnecting.Backend.service.impl;

import com.Kartconnecting.Backend.model.User;
import com.Kartconnecting.Backend.repository.UserRepository;
import com.Kartconnecting.Backend.security.JwtUtil;
import com.Kartconnecting.Backend.security.LoginRequest;
import com.Kartconnecting.Backend.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    public String login(LoginRequest request) {

        System.out.println("LOGIN REQUEST: email=" + request.getEmail()
                + " password=" + request.getPassword());

        // Buscar usuario por correo
        User usuario = userRepository.findByEmail(request.getEmail());

        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado");
        }

        // Comparar contraseñas TAL CUAL están en la base
        if (!usuario.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Password incorrecta");
        }

        // Generar el JWT
        return jwtUtil.generateToken(usuario.getEmail());
    }

    @Override
    public User login(String email, String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }
}


