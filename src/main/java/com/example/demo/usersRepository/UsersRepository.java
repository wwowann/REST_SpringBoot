package com.example.demo.usersRepository;

import com.example.demo.service.Authorities;

import java.util.ArrayList;
import java.util.List;

public class UsersRepository {
    List<Authorities> list = new ArrayList<>();
    public List<Authorities> getUserAuthorities(String user, String password) {
        if (user.equals("") || password.equals("")) return new ArrayList<>();
        return list;
    }
}
