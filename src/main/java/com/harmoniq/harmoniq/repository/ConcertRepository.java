package com.harmoniq.harmoniq.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harmoniq.harmoniq.model.Concert;
import com.harmoniq.harmoniq.model.User;

public interface ConcertRepository extends JpaRepository<Concert, Long> {
    List<Concert> findByOrganizer(User organizer);
}
