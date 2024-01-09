package com.example.demo.service;

import com.example.demo.Entity.Distance;
import com.example.demo.Entity.Place;
import com.example.demo.dto.MemberDto;
import com.example.demo.dto.PlaceDto;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaceService {
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public List<PlaceDto> findSurround(Long meter, Long count, Double y, Double x) {
        List<Place> places = placeRepository.findAll();
        List<PlaceDto> dtos = new ArrayList<>();
        Distance here = new Distance(x, y);
        for(Place place : places) {
            Distance there = new Distance(place.getAxisX(), place.getAxisY());
            double dist = Distance.getDist(here, there);
            for(long i=1; i<=count; i++) {
                double length = (double)i*meter;
                if(dist <= length) {
                    PlaceDto pdto = place.toDto();
                    pdto.setSize(i);
                    dtos.add(pdto);
                    break;
                }
            }
        }
        return dtos;
    }

}
