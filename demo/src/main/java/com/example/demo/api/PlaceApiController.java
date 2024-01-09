package com.example.demo.api;

import com.example.demo.dto.MemberDto;
import com.example.demo.dto.PlaceDto;
import com.example.demo.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlaceApiController {
    @Autowired
    private PlaceService placeService;

    @PostMapping("/find")
    public ResponseEntity<List<PlaceDto>> find(@RequestBody MemberDto dto) {
        List<PlaceDto> dtos = placeService.findSurround(dto, 200, 100, 200);
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }
}
