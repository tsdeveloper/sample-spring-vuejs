package com.tsdeveloper.github.samplespringvuejs.services;

import com.tsdeveloper.github.samplespringvuejs.entities.User;
import com.tsdeveloper.github.samplespringvuejs.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllPost(){
        return userRepository.findAll();
    }

    public void insert(User user) {
    user.setPassword(getPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){ return new BCryptPasswordEncoder();}


}
