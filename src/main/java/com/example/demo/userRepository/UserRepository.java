package com.example.demo.userRepository;

import com.example.demo.service.Authorities;
import com.example.demo.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserRepository {
    Map<User, List<Authorities>> userListMap;
    List<Authorities> list = new ArrayList<>();

    public UserRepository(Map<User, List<Authorities>> userListMap) {
        this.userListMap = userListMap;
    }

    public List<Authorities> getUserAuthorities(String name, String password) {
        if (name.equals("") || password.equals("")) return new ArrayList<>();
        User user = new User(name, password);
        if (userListMap.isEmpty()) return new ArrayList<>();
        userListMap.put(user, list);
        return userListMap.get(user);
    }
}
