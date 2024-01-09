package com.example.demo.service;

import com.example.demo.Entity.Distance;
import com.example.demo.Entity.MemberCategory;
import com.example.demo.Entity.Place;
import com.example.demo.dto.MemberDto;
import com.example.demo.dto.PlaceDto;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.MemberCategoryRepository;
import com.example.demo.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class PlaceService {
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private MemberCategoryRepository memberCategoryRepository;

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
    public List<PlaceDto> findSurround(Long memberId, Long meter, Long count, Double y, Double x) {
        List<MemberCategory> memberCategories = memberCategoryRepository.findAllByMember(memberId);
        HashSet<Long> hashSet = new HashSet<>();
        for(MemberCategory memberCategory : memberCategories) {
            hashSet.add(memberCategory.getCategory().getId());
        }
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
                    if(hashSet.contains(place.getCategoryId())) pdto.setSize(i);
                    else pdto.setSize(0L);
                    dtos.add(pdto);
                    break;
                }
            }
        }
        return dtos;
    }

}
