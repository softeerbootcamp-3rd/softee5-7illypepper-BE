package com.example.demo.api;

import com.example.demo.Entity.Member;
import com.example.demo.dto.MemberDto;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConfigApiController {
    @Autowired
    private MemberService memberService;

    @PatchMapping("/config/{memberId}")
    public ResponseEntity<MemberDto> create(@RequestBody MemberDto memberDto,
                                            @PathVariable Long memberId) {
        MemberDto result = memberService.update(memberDto, memberId);
        return (result != null) ?
                ResponseEntity.status(HttpStatus.OK).body(result):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @GetMapping("/config/{memberId}")
    public ResponseEntity<MemberDto> show(@PathVariable Long memberId) {
        MemberDto dto = memberService.show(memberId);
        return (dto != null)?
                ResponseEntity.status(HttpStatus.OK).body(dto):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
}
