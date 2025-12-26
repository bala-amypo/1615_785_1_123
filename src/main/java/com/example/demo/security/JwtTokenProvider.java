package com.example.demo.security;

import io.jsonwebtoken.*;
import java.util.*;

public class JwtTokenProvider {

    private final String SECRET = "secret-key";

    public String generateToken(Long id, String email, String role) {
        return Jwts.builder()
                .claim("id", id)
                .claim("email", email)
                .claim("role", role)
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET)
                .parseClaimsJws(token).getBody();
    }

    public String getEmailFromToken(String token) {
        return getClaims(token).get("email", String.class);
    }

    public Long getUserIdFromToken(String token) {
        return getClaims(token).get("id", Long.class);
    }

    public String getRoleFromToken(String token) {
        return getClaims(token).get("role", String.class);
    }
}
