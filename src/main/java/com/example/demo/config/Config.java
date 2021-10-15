package com.example.demo.config;

import com.example.demo.myAnnotation.HeaderUserArgumentResolver;
import com.example.demo.service.Authorities;
import com.example.demo.service.HandlerMethodArgumentResolver;
import com.example.demo.user.User;
import com.example.demo.userRepository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration

public class Config implements WebMvcConfigurer{
    @Bean
    public void addArgumentResolver(
            List<HandlerMethodArgumentResolver> argumentResolvers){
    argumentResolvers.add(new HeaderUserArgumentResolver());}


    @Bean
    public UserRepository userRepository(@Value("${com.example.demo.name}") String name,
                                         @Value("${com.example.demo.password}") String password) {
        Map<User, List<Authorities>> map = new HashMap<>();
        map.put(new User(name, password), List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE));
        return new UserRepository(map);
    }

}
