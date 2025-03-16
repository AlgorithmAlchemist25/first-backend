package com.harmoniq.harmoniq.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harmoniq.harmoniq.model.User;
import com.harmoniq.harmoniq.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository UserRepository;

    public Optional<User> getUserById(Long id) {
        return UserRepository.findById(id);
    }
}
