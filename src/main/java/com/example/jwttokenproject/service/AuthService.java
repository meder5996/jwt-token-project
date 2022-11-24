package com.example.jwttokenproject.service;

import com.example.jwttokenproject.dto.AuthRequest;
import com.example.jwttokenproject.dto.AuthResponse;

public interface AuthService {

    AuthResponse returnToken(AuthRequest authRequest);
}
