package com.example.demo.Entity;

import com.example.demo.dto.RouteDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name="route_id")
    private Long id;

    private String name;

    private Long length;

    private Long estimatedTime;

    private Long rateTotal;

    private Long rateCount;

    private double axisX;

    private double axisY;

    public void changeRate(Long score) {
        this.rateCount++;
        this.rateTotal += score;
    }
    public RouteDto toDto() {
        return new RouteDto(id, name, length, estimatedTime,
                rateTotal, rateCount, axisX, axisY);
    }
}