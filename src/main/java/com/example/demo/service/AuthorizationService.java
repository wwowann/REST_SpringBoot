package com.example.demo.service;

import com.example.demo.handlerException.InvalidCredentials;
import com.example.demo.handlerException.UnauthorizedUser;
import com.example.demo.userRepository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public class AuthorizationService {
    private final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String name, String password) {
        if (isEmpty(name) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getAuthorities(name, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown name user " + name);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}