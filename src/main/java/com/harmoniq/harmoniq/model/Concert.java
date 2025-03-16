package com.harmoniq.harmoniq.model;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "concerts")
@Data
public class Concert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDateTime date;
    private String location;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private User organizer;
}
