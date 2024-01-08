package com.example.demo.controller;

import com.example.demo.Entity.Member;
import com.example.demo.dto.MemberDto;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MemberService memberService;

    @GetMapping("/members")
    public String index(Model model) {
        List<Member> memberEntityList = memberRepository.findAll();
        model.addAttribute("memberList", memberEntityList);
        return "members/index";
    }
    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model) {
        Member memberEntity = memberRepository.findById(id).orElse(null);
        model.addAttribute("member", memberEntity);
        return "article_list";
    }
    @GetMapping("/members/new")
    public String create() {
        return "members/new";
    }
    @PostMapping("/members/create")
    public String create(@ModelAttribute MemberDto memberDto) {
        Member created = memberService.create(memberDto).toEntity();
        return "redirect:/members";
    }
}