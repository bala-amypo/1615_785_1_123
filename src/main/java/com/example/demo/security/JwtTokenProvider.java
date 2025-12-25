package com.example.demo.security;

import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;
@Component
public class JwtTokenProvider {

    public boolean validateToken(String token) {
        return token != null && !token.isEmpty();
    }
}
