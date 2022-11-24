package com.example.jwttokenproject.controller;

import com.example.jwttokenproject.dto.AuthRequest;
import com.example.jwttokenproject.dto.AuthResponse;
import com.example.jwttokenproject.dto.UserRequest;
import com.example.jwttokenproject.dto.UserResponse;
import com.example.jwttokenproject.service.AuthService;
import com.example.jwttokenproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/registration")
    public UserResponse registration(@RequestBody UserRequest userRequest){
        return userService.save(userRequest);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest){
        return authService.returnToken(authRequest);
    }
}
