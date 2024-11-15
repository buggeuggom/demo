package com.ajou.demo.controller.response.server;


import com.ajou.demo.dto.server.ServerStorageIntroDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ServerStorageIntroResponse {
    private Long id;

    private String name;
    private String quantity;
    private String introductionYear;

    private ServerStorageIntroResponse(Long id, String name, String quantity, String introductionYear) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.introductionYear = introductionYear;
    }

    public static ServerStorageIntroResponse of(ServerStorageIntroDto dto) {
        return new ServerStorageIntroResponse(dto.getId(), dto.getName(), dto.getQuantity(), dto.getIntroductionYear());
    }
}
