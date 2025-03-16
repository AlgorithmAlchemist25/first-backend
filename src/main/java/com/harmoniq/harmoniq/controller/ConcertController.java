package com.harmoniq.harmoniq.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.harmoniq.harmoniq.model.Concert;
import com.harmoniq.harmoniq.model.Role;
import com.harmoniq.harmoniq.model.User;
import com.harmoniq.harmoniq.repository.UserRepository;
import com.harmoniq.harmoniq.service.ConcertService;

@RestController
@RequestMapping("/concerts")
public class ConcertController {
    @Autowired
    private ConcertService concertService;
    
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public ResponseEntity<?> createConcert(@RequestBody Long userId, @RequestBody Concert concert) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }

        User user = userOptional.get();
        if (user.getRole() != Role.ORGANIZER) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Only organizers can create concerts.");
        }

        concert.setOrganizer(user);
        Concert savedConcert = concertService.createConcert(concert);
        return ResponseEntity.ok(savedConcert);
    }

    @GetMapping("/by-organizer/{id}")
    public ResponseEntity<List<Concert>> getConcertsByOrganizer(@PathVariable Long id) {
        User organizer = new User();
        organizer.setId(id);
        return ResponseEntity.ok(concertService.getConcertsByOrganizer(organizer));
    }
}

