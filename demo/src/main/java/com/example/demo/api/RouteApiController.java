package com.example.demo.api;

import com.example.demo.dto.MemberDto;
import com.example.demo.dto.RouteDto;
import com.example.demo.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RouteApiController {
    @Autowired
    private RouteService routeService;

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
}