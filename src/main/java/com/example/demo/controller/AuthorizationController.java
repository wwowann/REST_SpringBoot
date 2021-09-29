package com.example.demo.controller;

import com.example.demo.service.Authorities;
import com.example.demo.service.AuthorizationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
//@RequestMapping("/")
public class AuthorizationController {
    AuthorizationService service;

   @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("name") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }
}
