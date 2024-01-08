package com.example.demo.Entity;

import com.example.demo.dto.MemberDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name="member_id")
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

    public MemberDto toDto() {
        return new MemberDto(id, phone, nickname, password, name,
                birth, gender, job, axisX, axisY);
    }

    public void patch(Member member) {
        if(member.getPhone() != null) this.phone = member.getPhone();;
        if(member.getNickname() != null) this.nickname = member.getNickname();
        if(member.getPassword() != null) this.password = member.getPassword();
        if(member.getName() != null) this.name = member.getName();
        if(member.getBirth() != null) this.birth = member.getBirth();
        if(member.getGender() != null) this.gender = member.getGender();
        if(member.getJob() != null) this.job = member.getJob();
        this.axisX = member.getAxisX();
        this.axisY = member.getAxisY();
    }
}