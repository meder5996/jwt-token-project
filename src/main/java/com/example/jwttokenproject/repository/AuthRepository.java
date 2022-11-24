package com.example.jwttokenproject.repository;

import com.example.jwttokenproject.model.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<Auth, Long> {
    Auth findByEmail(String email);
}
