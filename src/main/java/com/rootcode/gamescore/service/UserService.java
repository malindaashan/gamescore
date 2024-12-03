package com.rootcode.gamescore.service;

import com.rootcode.gamescore.domain.User;
import com.rootcode.gamescore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserById(long userId){
       Optional<User> user =  userRepository.findById(userId);
        return user.orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
}
