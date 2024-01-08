package com.example.demo.api;

import com.example.demo.Entity.Member;
import com.example.demo.dto.MemberDto;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigApiController {
    @Autowired
    private MemberService memberService;

    @PatchMapping("/config")
    public ResponseEntity<Member> create(@RequestBody MemberDto memberDto) {
        Member created = memberService.update(memberDto).toEntity();
        return ResponseEntity.status(HttpStatus.OK).body(created);
    }
}
