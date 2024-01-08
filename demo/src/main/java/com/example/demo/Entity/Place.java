package com.example.demo.Entity;

import com.example.demo.dto.PlaceDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name="place_id")
    private Long id;

    private Long categoryId;

    private String name;

    private String thumbnail;

    private String content;

    private double rating;

    private double axisX;

    private double axisY;

    public PlaceDto toDto() {
        return new PlaceDto(id, categoryId, name, thumbnail,
                content, rating, axisX, axisY);
    }
}