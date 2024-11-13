package com.ajou.demo.dto;

import com.ajou.demo.domain.Member;
import lombok.Getter;


@Getter
public class MemberDto {

    private Long id;

    private String email;

    private String username;

    private String password;


    private MemberDto(Long id, String email, String username, String password) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public static MemberDto of(Member member) {
        return new MemberDto(member.getId(), member.getEmail(), member.getUsername(), member.getPassword());
    }
}
