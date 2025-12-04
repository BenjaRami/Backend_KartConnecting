package com.Kartconnecting.Backend.service;

import com.Kartconnecting.Backend.model.User;
import com.Kartconnecting.Backend.security.LoginRequest;

public interface AuthService {
    User login(String email, String password);

    String login(LoginRequest request);
}

