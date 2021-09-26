package com.example.demo.controller;

import com.example.demo.handlerException.InvalidCredentials;
import com.example.demo.myAnnotations.LoginUser;
import com.example.demo.service.ArgumentResolver;
import com.example.demo.service.Authorities;
import com.example.demo.users.Users;
import com.example.demo.service.AuthorizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@RestController
@RequestMapping("/")
public class AuthorizationController {
    AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }
}

