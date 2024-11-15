package com.ajou.demo.controller.response.server;

import com.ajou.demo.domain.server.MainComputerEquipment;
import com.ajou.demo.dto.server.MainComputerEquipmentDto;
import lombok.Getter;

import static java.lang.Math.min;

@Getter
public class MainComputerEquipmentResponse {

    private Long id;

    private String use; //용도
    private String equipmentName;//장비명
    private String modelName;//모델명
    private String os; //os
    private String introductionDate; //도입일자
    private String assetNumber;//자산번호
    private String sn;//sn
    private String number;//번호

    /*
    페이징 기능을 위한 생성자
     */
    public MainComputerEquipmentResponse(MainComputerEquipment entity) {
        this.id = entity.getId();
        this.use = entity.getUse();
        this.equipmentName = entity.getEquipmentName();
        this.modelName = entity.getModelName();
        this.os = entity.getOs();
        this.introductionDate = entity.getIntroductionDate();
        this.assetNumber = entity.getAssetNumber();
        this.sn = entity.getSn();
        this.number = entity.getNumber();
    }

    private MainComputerEquipmentResponse(Long id, String use, String equipmentName, String modelName, String os, String introductionDate, String assetNumber, String sn, String number) {
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

    public static MainComputerEquipmentResponse of(MainComputerEquipmentDto dto) {
        return new MainComputerEquipmentResponse(
                dto.getId(),
                dto.getUse(),
                dto.getEquipmentName(),
                dto.getModelName(),
                dto.getOs(),
                dto.getIntroductionDate(),
                dto.getAssetNumber(),
                dto.getSn(),
                dto.getNumber());
    }
}
