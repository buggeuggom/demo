package com.ajou.demo.controller;

import com.ajou.demo.controller.request.MemberLoginRequest;
import com.ajou.demo.controller.response.member.MemberResponse;
import com.ajou.demo.dto.MemberDto;
import com.ajou.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public MemberResponse login(@RequestBody MemberLoginRequest request) {

        MemberDto memberDto = memberService.login(request);

        return MemberResponse.of(memberDto);
    }

}
