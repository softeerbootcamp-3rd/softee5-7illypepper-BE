package com.example.demo.dto;

import com.example.demo.Entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
    private Long id;

    private String phone;

    private String nickname;

    private String password;

    private String name;

    private LocalDate birth;

    private String gender;

    private String job;

    private double axisX;

    private double axisY;

    public Member toEntity() {
        return new Member(id, phone, nickname, password, name,
                birth, gender, job, axisX, axisY);
    }
}