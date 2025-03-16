package com.harmoniq.harmoniq.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harmoniq.harmoniq.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);
}

