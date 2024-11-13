package com.ajou.demo.controller.response.member;

import com.ajou.demo.dto.MemberDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberResponse {

    private Long id;
    private String userName;
    private String email;

    private MemberResponse(Long id, String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }

    public static MemberResponse of(MemberDto dto) {
        return new MemberResponse(
                dto.getId(),
                dto.getUsername(),
                dto.getEmail()
        );
    }
}
