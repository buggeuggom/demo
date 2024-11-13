package com.ajou.demo.service;

import com.ajou.demo.controller.request.MemberLoginRequest;
import com.ajou.demo.domain.Member;
import com.ajou.demo.dto.MemberDto;
import com.ajou.demo.exception.GlobalApplicationException;
import com.ajou.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.ajou.demo.exception.ErrorCode.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public MemberDto login(MemberLoginRequest request) {

        Member member = memberRepository.findByEmail(request.getEmail()).orElseThrow(() -> {
            throw new GlobalApplicationException(USER_NOT_FOUND);
        });

        if (!member.getPassword().equals(request.getPassword())) {

            throw new GlobalApplicationException(USER_NOT_FOUND);
        }

        return MemberDto.of(member)
;
    }
}
