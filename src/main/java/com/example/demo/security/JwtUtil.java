package com.example.demo.security;

import com.example.demo.entity.Employee;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(Employee employee) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("email", employee.getEmail());
        claims.put("role", employee.getRole().toUpperCase()); // case-insensitive
        claims.put("userId", employee.getId());

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(employee.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

    public Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isTokenValid(String token, Employee employee) {
        Claims claims = extractClaims(token);
        String email = claims.get("email", String.class);
        return email.equals(employee.getEmail()) && !isTokenExpired(token);
    }

    public boolean isTokenExpired(String token) {
        return extractClaims(token)
                .getExpiration()
                .before(new Date());
    }
}
