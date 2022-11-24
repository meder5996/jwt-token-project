package com.example.jwttokenproject.service.impl;

import com.example.jwttokenproject.config.jwt.JwtUtil;
import com.example.jwttokenproject.dto.AuthRequest;
import com.example.jwttokenproject.dto.AuthResponse;
import com.example.jwttokenproject.model.Role;
import com.example.jwttokenproject.model.User;
import com.example.jwttokenproject.repository.UserRepository;
import com.example.jwttokenproject.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    @Override
    public AuthResponse returnToken(AuthRequest authRequest) {
        
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getEmail(),
                        authRequest.getPassword()));

        String generateToken = jwtUtil.generateToken(authentication);

        User user = userRepository.findByEmail(authRequest.getEmail());
        List<Role> roles = user.getAuth().getRoles();
        String role = String.valueOf(roles.get(0));

        return new AuthResponse(
                user.getEmail(),
                role,
                generateToken
        );
    }
}
