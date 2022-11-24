package com.example.jwttokenproject.mapper;

import com.example.jwttokenproject.dto.UserRequest;
import com.example.jwttokenproject.dto.UserResponse;
import com.example.jwttokenproject.model.Auth;
import com.example.jwttokenproject.model.User;
import com.example.jwttokenproject.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final RoleRepository roleRepository;

    public User mapToEntity(UserRequest userRequest){
        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());

        Auth auth = new Auth();
        auth.setEmail(userRequest.getEmail());
        auth.setPassword(userRequest.getPassword());
        auth.setRoles(Collections.singletonList(roleRepository.findByName("USER")));

        user.setAuth(auth);

        return user;
    }

    public UserResponse mapToResponse(User user){
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword()
        );
    }

    public List<UserResponse> mapToResponse(List<User> users){
        List<UserResponse> userResponses = new ArrayList<>();

        for (User user: users){
            userResponses.add(mapToResponse(user));
        }
        return userResponses;
    }
}
