package com.example.demo.service;

import com.example.demo.handlerException.InvalidCredentials;
import com.example.demo.handlerException.UnauthorizedUser;
import com.example.demo.user.User;
import com.example.demo.userRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationService {

    private final UserRepository userRepository;

//    @Autowired
    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        if (user.getName().equals("") || user.getPassword().equals("")) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities;
        userAuthorities = userRepository.getAuthorities(user);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown name user " + user.getName());
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