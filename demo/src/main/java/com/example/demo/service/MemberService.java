package com.example.demo.service;

import com.example.demo.Entity.Member;
import com.example.demo.dto.MemberDto;
import com.example.demo.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Transactional
    public MemberDto create(MemberDto dto) {
        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //String encodedPassword = passwordEncoder.encode(dto.getPassword());
        Member member = dto.toEntity();
        Member Created = memberRepository.save(member);
        return Created.toDto();
    }
    public List<MemberDto> index() {
        List<Member> memberEntityList = memberRepository.findAll();
        List<MemberDto> dtos = new ArrayList<>();
        for(int i=0; i<memberEntityList.size(); i++) {
            dtos.add(memberEntityList.get(i).toDto());
        }
        return dtos;
    }
    public MemberDto login(String phone, String password) {
        Member member = memberRepository.findByPhone(phone).orElse(null);
        if(member != null) {
            if(member.getPassword().equals(password)) {
                return member.toDto();
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }

    @Transactional
    public MemberDto update(MemberDto memberDto) {
        Member member = memberDto.toEntity();
        Member target = memberRepository.findById(memberDto.getId()).orElse(null);
        if(target == null) return null;
        target.patch(member);
        return target.toDto();
    }

    public MemberDto findByPhone(String phone) {
        Member memberEntity = memberRepository.findByPhone(phone).orElse(null);
        if(memberEntity != null) return memberEntity.toDto();
        else return null;
    }
}