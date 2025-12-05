package com.Kartconnecting.Backend.service;

import com.Kartconnecting.Backend.model.User;
import com.Kartconnecting.Backend.security.LoginRequest;

public interface AuthService {

    String login(LoginRequest request);

    User register(User usuario);
}

