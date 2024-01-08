package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name="review_id")
    private Long id;

    //private Long userId;

    //private Long routeId;

    private double rating;

    private String content;
}
