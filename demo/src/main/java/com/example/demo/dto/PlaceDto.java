package com.example.demo.dto;

import com.example.demo.Entity.Place;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class PlaceDto {
    private Long id;
    private Long categoryId;
    private String name;
    private String thumbnail;
    private String content;
    private double rating;
    private double axisX;
    private double axisY;

    public Place toEntity() {
        return new Place(id, categoryId, name, thumbnail,
                content, rating, axisX, axisY);
    }
}
