package com.example.demo.dto;

import jakarta.validation.constraints.*;

public class AuthRegisterRequest {

    @NotBlank
    private String username;

    @Email
    private String email;

    @NotBlank
    private String password;

    // getters and setters
}
