package com.example.demo.controller;

import com.example.demo.dto.AuthRegisterRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/register")
    public String register(@Valid @RequestBody AuthRegisterRequest request) {
        return "User Registered";
    }
}
