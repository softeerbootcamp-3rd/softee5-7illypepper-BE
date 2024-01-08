package com.example.demo.repository;

import com.example.demo.Entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RouteRepository extends JpaRepository<Route, Long> {

    Optional<Route> findById(Long routeId);
}