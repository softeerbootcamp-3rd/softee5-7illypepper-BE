package com.example.demo.service;

import com.example.demo.Entity.Route;
import com.example.demo.dto.MemberDto;
import com.example.demo.dto.RouteDto;
import com.example.demo.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    public RouteDto rating(MemberDto dto, Long routeId, Long score) {
        Route route = routeRepository.findById(routeId).orElse(null);
        if(route == null) return null;
        route.changeRate(score);
        Route result = routeRepository.save(route);
        return result.toDto();
    }
    public List<RouteDto> findRoute(MemberDto dto, Long time, List<String> theme) {
        List<Route> routes = routeRepository.findAll();
        List<RouteDto> dtos = new ArrayList<>();
        for(Route r : routes) {
            if(r.getEstimatedTime() > time + 3 || r.getEstimatedTime() < time - 3) continue;
            dtos.add(r.toDto());
        }
        return dtos;
    }
}