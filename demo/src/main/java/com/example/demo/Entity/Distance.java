package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Distance {
    private double axisX;
    private double axisY;
    public static double getDist(Distance here, Distance there) {
        double x1 = here.axisX;
        double y1 = here.axisY;
        double x2 = there.axisX;
        double y2 = there.axisY;
        double theta = x1 - x2;
        double dist = Math.sin(deg2rad(y1))* Math.sin(deg2rad(y2)) + Math.cos(deg2rad(y1))*Math.cos(deg2rad(y2))*Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60*1.1515*1609.344;

        return dist; //단위 meter
    }
    private static double deg2rad(double deg){
        return (deg * Math.PI/180.0);
    }
    //radian(라디안)을 10진수로 변환
    private static double rad2deg(double rad){
        return (rad * 180 / Math.PI);
    }
}
