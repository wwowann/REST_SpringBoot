package com.example.demo.userRepository;

import com.example.demo.service.Authorities;
import com.example.demo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import java.util.*;

@Repository
//@ConfigurationProperties(prefix = "demo")
public class UserRepository {

    private final Map<User, List<Authorities>> userListMap;

    public UserRepository(Map<User, List<Authorities>> userListMap) {
        this.userListMap = userListMap;
    }

    @Autowired
    public void init(@Value("${com.example.demo.user}") String user, @Value("${com.example.demo.password}") String password) {
        if (userListMap.isEmpty())
         userListMap.put(new User(user, password),
                    Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE));
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (user.equals("") || password.equals("")) return new ArrayList<>();
        return Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE);
    }
//    public List<Authorities> getAuthorities(@Value("${com.example.demo.user}") String user, @Value("${com.example.demo.user}") String password) {
//        if (user.equals("") || password.equals("")) return new ArrayList<>();
//        User userValue = new User(user, password);
//        if (!userListMap.containsKey(userValue))
//            userListMap.put(userValue, Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE));
//        return userListMap.get(userValue);
//    }
}
