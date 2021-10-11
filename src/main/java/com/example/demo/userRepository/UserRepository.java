package com.example.demo.userRepository;

import com.example.demo.service.Authorities;
import com.example.demo.user.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class UserRepository {

    public Map<User, List<Authorities>> userListMap;

    public UserRepository(Map<User, List<Authorities>> userListMap) {
        this.userListMap = userListMap;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (user.equals("") || password.equals("")) return new ArrayList<>();
        return Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE);
    }
}

