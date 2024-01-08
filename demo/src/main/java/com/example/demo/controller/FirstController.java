package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
import com.example.demo.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/")
    public String base() {
        return "redirect:/login";
    }
    @GetMapping("/signup")
    public String home() {
        return "signup";
    }
    @PostMapping("/login")
    public String postLogin(@RequestParam(value = "phone") String phone,
                            @RequestParam(value = "password") String password,
                            HttpSession session) {
        MemberDto result = memberService.login(phone, password);
        if(result == null) return "redirect:/";
        session.setAttribute("sessionUser", result);
        return "redirect:/home";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
    @GetMapping("/info")
    public String info() {
        return "";
    }
    @PostMapping("/signup")
    public String signup(@ModelAttribute MemberDto dto) {
        memberService.create(dto);
        return "redirect:/login";
    }
    @GetMapping("/select")
    public String hello() {
        return "select";
    }
    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }
    @GetMapping("/home")
    public String loginSuccess(HttpSession session) {
        return "home";
    }
    @GetMapping("/edit")
    public String getEdit() {
        return "edit";
    }
    @GetMapping("/test")
    public String test() {
        return "test";
    }
}