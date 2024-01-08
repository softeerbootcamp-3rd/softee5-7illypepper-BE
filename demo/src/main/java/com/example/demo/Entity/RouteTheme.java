package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Cleanup;

@Entity
public class RouteTheme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    @ManyToOne
    @JoinColumn(name = "theme_id")
    private Theme theme;
}
