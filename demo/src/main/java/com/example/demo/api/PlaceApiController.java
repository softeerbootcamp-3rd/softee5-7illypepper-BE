package com.example.demo.api;

import com.example.demo.dto.MemberDto;
import com.example.demo.dto.PlaceDto;
import com.example.demo.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlaceApiController {
    @Autowired
    private PlaceService placeService;

    @GetMapping("/find")
    public ResponseEntity<List<PlaceDto>> find(@RequestParam(name = "meter") Long meter,
                                               @RequestParam(name = "count") Long count,
                                               @RequestParam(name = "y") Double y,
                                               @RequestParam(name = "x") Double x) {
        List<PlaceDto> dtos = placeService.findSurround(meter, count, y, x);
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }
}
