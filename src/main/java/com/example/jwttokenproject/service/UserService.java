package com.example.jwttokenproject.service;

import com.example.jwttokenproject.dto.UserRequest;
import com.example.jwttokenproject.dto.UserResponse;

public interface UserService {

    UserResponse save(UserRequest userRequest);
}
