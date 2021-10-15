package com.example.demo.userRepository;

import com.example.demo.service.Authorities;
import com.example.demo.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class UserRepository {

    public Map<User, List<Authorities>> userListMap;

    public UserRepository(Map<User, List<Authorities>> userListMap) {
        this.userListMap = userListMap;
    }

    public List<Authorities> getAuthorities(User user) {
        if (userListMap.containsKey(user)) return userListMap.get(user);
        return new ArrayList<>();
    }
}
