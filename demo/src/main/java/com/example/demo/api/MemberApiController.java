package com.example.demo.api;

import com.example.demo.Entity.Member;
import com.example.demo.dto.FavoriteDto;
import com.example.demo.dto.MemberDto;
import com.example.demo.service.MemberService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberApiController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/member/signin")
    public ResponseEntity<Member> create(@RequestBody MemberDto memberDto) {
        Member created = memberService.create(memberDto).toEntity();
        return ResponseEntity.status(HttpStatus.OK).body(created);
    }

    @GetMapping("/member/check/{phone}")
    public ResponseEntity<MemberDto> check(@PathVariable String phone) {
        MemberDto result = memberService.findByPhone(phone);
        return (result != null) ?
                ResponseEntity.status(HttpStatus.OK).body(result):
                ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @PostMapping("/member/favorite")
    public ResponseEntity<MemberDto> favorite(@RequestBody FavoriteDto dto) {
        MemberDto result = memberService.favorite(dto.getMemberId(), dto.getCategory());
        return (result != null) ?
                ResponseEntity.status(HttpStatus.OK).body(result):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
