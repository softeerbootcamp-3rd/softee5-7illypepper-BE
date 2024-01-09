package com.example.demo.service;

import com.example.demo.Entity.OrderOfRoute;
import com.example.demo.Entity.Place;
import com.example.demo.Entity.Route;
import com.example.demo.dto.MemberDto;
import com.example.demo.dto.RouteDto;
import com.example.demo.repository.OrderOfRouteRepository;
import com.example.demo.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private OrderOfRouteRepository orderOfRouteRepository;

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
    public RouteDto create(Place[] arr) {
        if(arr.length == 0) return null;
        Route created = routeRepository.save(new Route(null, "경로", 0L, 30L, 0L, 0L, arr[0].getAxisX(), arr[0].getAxisY()));
        for(long i=0; i<arr.length; i++) {
            OrderOfRoute o = orderOfRouteRepository.save(new OrderOfRoute(null, created, arr[(int)i], (Long)(i+1)));
        }
        
        return created.toDto();
    }
}