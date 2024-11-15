package com.ajou.demo.dto.server;

import com.ajou.demo.domain.server.MainComputerEquipment;
import lombok.Builder;
import lombok.Getter;

import static lombok.AccessLevel.*;

@Getter
public class MainComputerEquipmentDto {

    private Long id;

    private String use; //용도
    private String equipmentName;//장비명
    private String modelName;//모델명
    private String os; //os
    private String introductionDate; //도입일자
    private String assetNumber;//자산번호
    private String sn;//sn
    private String number;//번호

    @Builder(access = PRIVATE)
    private MainComputerEquipmentDto(Long id, String use, String equipmentName, String modelName, String os, String introductionDate, String assetNumber, String sn, String number) {
        this.id = id;
        this.use = use;
        this.equipmentName = equipmentName;
        this.modelName = modelName;
        this.os = os;
        this.introductionDate = introductionDate;
        this.assetNumber = assetNumber;
        this.sn = sn;
        this.number = number;
    }

    public static MainComputerEquipmentDto of(MainComputerEquipment equipment) {
        return MainComputerEquipmentDto.builder()
                .id(equipment.getId())
                .use(equipment.getUse())
                .equipmentName(equipment.getEquipmentName())
                .modelName(equipment.getModelName())
                .os(equipment.getOs())
                .introductionDate(equipment.getIntroductionDate())
                .assetNumber(equipment.getAssetNumber())
                .sn(equipment.getSn())
                .number(equipment.getNumber())
                .build();

    }
}
