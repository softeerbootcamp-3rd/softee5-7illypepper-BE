package com.example.demo.api;

import com.example.demo.Entity.Place;
import com.example.demo.Entity.Route;
import com.example.demo.Entity.RouteTheme;
import com.example.demo.dto.MemberDto;
import com.example.demo.dto.RouteDto;
import com.example.demo.dto.ThemeDto;
import com.example.demo.repository.RouteThemeRepository;
import com.example.demo.service.RouteService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class RouteApiController {
    @Autowired
    private RouteService routeService;
    @Autowired
    private RouteThemeRepository routeThemeRepository;

    @PostMapping("/course/rate")
    public ResponseEntity<RouteDto> rate(@RequestParam MemberDto dto,
                                         @RequestParam Long routeId,
                                         @RequestParam Long score){
        RouteDto result = routeService.rating(dto, routeId, score);
        return (result != null) ?
                ResponseEntity.status(HttpStatus.OK).body(result):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
    @PostMapping("/course/select")
    public ResponseEntity<List<RouteDto>> select(@RequestParam MemberDto dto,
                                                 @RequestParam Long time,
                                                 @RequestParam List<String> theme) {
        List<RouteDto> result = routeService.findRoute(dto, time, theme);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @PostMapping("/course/create")
    public ResponseEntity<RouteDto> create(@RequestParam(value = "arr") Place[] arr) {
        RouteDto dto = routeService.create(arr);
        return (dto != null) ?
                ResponseEntity.status(HttpStatus.OK).body(dto):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @GetMapping("/course/theme/{courseId}")
    public ResponseEntity<List<ThemeDto>> theme(@PathVariable Long courseId) {
        List<ThemeDto> result = new ArrayList<>();
        List<RouteTheme> all = routeThemeRepository.findAll();
        for(RouteTheme r : all) {
            if(Objects.equals(r.getRouteId(), courseId)) result.add(new ThemeDto(null, r.getTheme()));
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}