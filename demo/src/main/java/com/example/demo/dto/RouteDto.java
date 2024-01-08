package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RouteDto {
    private Long id;

    private String name;

    private Long length;

    private Long estimatedTime;

    private Long rateTotal;

    private Long rateCount;

    private double axisX;

    private double axisY;
}
