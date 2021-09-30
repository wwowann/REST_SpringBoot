package com.example.demo.userRepository;

import com.example.demo.service.Authorities;
import com.example.demo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
@Repository
public class UserRepository {
    private final Map<User, List<Authorities>> userListMap;

    public UserRepository(Map<User, List<Authorities>> userListMap) {
        this.userListMap = userListMap;
    }

    public List<Authorities> getAuthorities(String userName, String password) {
        if (userName.equals("") || password.equals("")) return new ArrayList<>();
        User user = new User(userName, password);
        if (!userListMap.containsKey(user))
        userListMap.put(user, Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE));
        return userListMap.get(user);
    }
}
