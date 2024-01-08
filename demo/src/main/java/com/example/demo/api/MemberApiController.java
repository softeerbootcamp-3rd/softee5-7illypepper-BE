package com.example.demo.api;

import com.example.demo.Entity.Member;
import com.example.demo.dto.MemberDto;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberApiController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/user/signin")
    public ResponseEntity<Member> create(@RequestBody MemberDto memberDto) {
        Member created = memberService.create(memberDto).toEntity();
        return ResponseEntity.status(HttpStatus.OK).body(created);
    }

    @PostMapping("/user/check")
    public ResponseEntity<MemberDto> check(@RequestParam(value = "phone") String phone) {
        MemberDto result = memberService.findByPhone(phone);
        return (result != null) ?
                ResponseEntity.status(HttpStatus.OK).body(result):
                ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
