package com.example.demo.dto;

import com.example.demo.Entity.Place;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
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
    private Long size;

    public Place toEntity() {
        return new Place(id, categoryId, name, thumbnail,
                content, rating, axisX, axisY, size);
    }
}
