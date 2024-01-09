package com.example.demo.repository;

import com.example.demo.Entity.RouteTheme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RouteThemeRepository extends JpaRepository<RouteTheme, Long> {

}
