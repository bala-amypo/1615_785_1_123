package com.example.demo.exception;


import org.springframework.web.bind.annotation.*;


@RestControllerAdvice
public class GlobalExceptionHandler {


@ExceptionHandler(IllegalArgumentException.class)
public String handleIllegal(IllegalArgumentException ex) {
return ex.getMessage();
}
}