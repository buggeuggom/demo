package com.ajou.demo.dto.server;

import com.ajou.demo.domain.server.MainComputerEquipment;
import com.ajou.demo.domain.server.ServerStorageIntro;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ServerStorageIntroDto {

    private Long id;

    private String name;
    private String quantity;
    private String introductionYear;


    @Builder
    private ServerStorageIntroDto(Long id, String name, String quantity, String introductionYear) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.introductionYear = introductionYear;
    }

    public static ServerStorageIntroDto of(ServerStorageIntro entity) {
        return ServerStorageIntroDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .quantity(entity.getQuantity())
                .introductionYear(entity.getIntroductionYear())
                .build();
    }
}
