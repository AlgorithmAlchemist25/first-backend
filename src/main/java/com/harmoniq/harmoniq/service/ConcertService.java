package com.harmoniq.harmoniq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harmoniq.harmoniq.model.Concert;
import com.harmoniq.harmoniq.model.User;
import com.harmoniq.harmoniq.repository.ConcertRepository;

@Service
public class ConcertService {
    @Autowired
    private ConcertRepository concertRepository;

    public Concert createConcert(Concert concert) {
        return concertRepository.save(concert);
    }

    public List<Concert> getConcertsByOrganizer(User organizer) {
        return concertRepository.findByOrganizer(organizer);
    }
}

