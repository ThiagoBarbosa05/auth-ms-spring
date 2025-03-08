package com.thiago.microservices.auth_ms.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record CreateUserRequest(

        @NotBlank(message = "First name is required")
        @Length(max = 100,message = "Max characters in this field")
        String firstName,

        @NotBlank(message = "Last name is required")
        @Length(max = 100,message = "Max characters in this field")
        String lastName,

        @Email(message = "Provide a valid email")
        @Length(max = 100,message = "Max characters in this field")
        String email,

        @NotBlank(message = "Password is required")
        @Length(min = 6, max = 100, message = "Password must be at least 6 characters long")
        String password
) {}
