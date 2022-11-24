package com.example.jwttokenproject.service.impl;

import com.example.jwttokenproject.dto.UserRequest;
import com.example.jwttokenproject.dto.UserResponse;
import com.example.jwttokenproject.mapper.UserMapper;
import com.example.jwttokenproject.repository.UserRepository;
import com.example.jwttokenproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserResponse save(UserRequest userRequest) {
        userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        return userMapper.mapToResponse(
                userRepository.save(
                        userMapper.mapToEntity(userRequest))
        );
    }
}
