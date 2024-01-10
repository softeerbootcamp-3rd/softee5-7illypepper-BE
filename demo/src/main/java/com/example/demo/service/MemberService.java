package com.example.demo.service;

import com.example.demo.Entity.Category;
import com.example.demo.Entity.Member;
import com.example.demo.Entity.MemberCategory;
import com.example.demo.dto.MemberDto;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.MemberCategoryRepository;
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
    @Autowired
    private MemberCategoryRepository memberCategoryRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public MemberDto create(MemberDto dto) {
        Member member = dto.toEntity();
        Member Created = memberRepository.save(member);
        return Created.toDto();
    }
    @Transactional
    public MemberDto update(MemberDto memberDto, Long id) {
        Member member = memberDto.toEntity();
        Member target = memberRepository.findById(id).orElse(null);
        if(target == null) return null;
        target.patch(member);
        return target.toDto();
    }

    public MemberDto findByPhone(String phone) {
        Member memberEntity = memberRepository.findByPhone(phone).orElse(null);
        if(memberEntity != null) return memberEntity.toDto();
        else return null;
    }

    public MemberDto show(Long memberId) {
        Member member = memberRepository.findById(memberId).orElse(null);
        if(member != null) return member.toDto();
        else return null;
    }

    public MemberDto favorite(Long id, String[] like) {
        Member target = memberRepository.findById(id).orElse(null);
        if(target == null) return null;
        for(String l : like) {
            Category c = categoryRepository.findByName(l).orElse(null);
            if(c == null) continue;
            memberCategoryRepository.save(new MemberCategory(null, target, c));
        }
        return target.toDto();
    }
}