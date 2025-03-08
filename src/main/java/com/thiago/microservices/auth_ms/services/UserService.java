package com.thiago.microservices.auth_ms.services;

import com.thiago.microservices.auth_ms.dto.CreateUserRequest;
import com.thiago.microservices.auth_ms.exceptions.ConflictException;
import com.thiago.microservices.auth_ms.models.User;
import com.thiago.microservices.auth_ms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createUser(CreateUserRequest createUserRequest) {
        Optional<User> existingUser = userRepository.findByEmail(createUserRequest.email());

        if(existingUser.isPresent()) {
            throw new ConflictException("User already exists");
        }

        String passwordHashed = passwordEncoder.encode(createUserRequest.password());

        User user = new User(
                createUserRequest.firstName(),
                createUserRequest.lastName(),
                createUserRequest.email(),
                createUserRequest.password()
        );

        userRepository.save(user);
    }
}
