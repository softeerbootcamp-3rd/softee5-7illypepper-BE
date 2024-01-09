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

    public List<PlaceDto> findSurround(MemberDto dto, double meter, int small, int big) {
        List<Place> places = placeRepository.findAll();
        List<PlaceDto> dtos = new ArrayList<>();
        Distance now = new Distance(dto.getAxisX(), dto.getAxisY());
        for(Place p : places) {
            Distance d = new Distance(p.getAxisX(), p.getAxisY());
            double dist = now.getDist(now.getAxisX(), now.getAxisY(), d.getAxisX(), d.getAxisY());
            if(dist  > (double)meter) continue;
            PlaceDto pdto = p.toDto();
            if(dist <= (double)small) pdto.setSize(1L);
            else pdto.setSize(0L);
            dtos.add(pdto);
        }
        return dtos;
    }

}
