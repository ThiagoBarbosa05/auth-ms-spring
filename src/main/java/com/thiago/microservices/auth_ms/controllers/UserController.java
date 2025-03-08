package com.thiago.microservices.auth_ms.controllers;

import com.thiago.microservices.auth_ms.dto.CreateUserRequest;
import com.thiago.microservices.auth_ms.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Object> createUser(
            @Valid @RequestBody CreateUserRequest createUserRequest
            ) {
        userService.createUser(createUserRequest);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
}
