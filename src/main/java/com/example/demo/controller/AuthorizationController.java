package com.example.demo.controller;

import com.example.demo.myAnnotation.UserValidator;
import com.example.demo.service.Authorities;
import com.example.demo.service.AuthorizationService;
import com.example.demo.user.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController

public class AuthorizationController {

    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize/{user}")
    public List<Authorities> getAuthorities(@UserValidator User user) {
             return service.getAuthorities(user);
    }

}

