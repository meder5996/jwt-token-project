package com.example.jwttokenproject.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "application.jwt")
public class JwtConfig {

    private  String secretKey;
    private String tokenPrefix;
    private Long expiration;

    public String getAuthorizationHeader(){
        return HttpHeaders.AUTHORIZATION;
    }
}
