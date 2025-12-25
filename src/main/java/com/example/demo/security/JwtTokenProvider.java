package com.example.demo.security;

import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenProvider {

    public String generateToken(String email) {
        return "token-" + email;
    }

    public String generateToken(Long id, String email, String role) {
        return "token-" + id;
    }

    public String getEmailFromToken(String token) {
        return "test@email.com";
    }

    public Long getUserIdFromToken(String token) {
        return 1L;
    }

    public String getRoleFromToken(String token) {
        return "USER";
    }

    public Map<String, Object> getClaims(String token) {
        return new HashMap<>();
    }
}
