package com.ajou.demo.domain.server;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class MainComputerEquipment {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String use; //용도
    private String equipmentName;//장비명
    private String modelName;//모델명
    private String os; //os
    private String introductionDate; //도입일자
    private String assetNumber;//자산번호
    private String sn;//sn
    private String number;//번호

    @Builder
    private MainComputerEquipment(String use, String equipmentName, String modelName, String os, String introductionDate, String assetNumber, String sn, String number) {
        this.use = use;
        this.equipmentName = equipmentName;
        this.modelName = modelName;
        this.os = os;
        this.introductionDate = introductionDate;
        this.assetNumber = assetNumber;
        this.sn = sn;
        this.number = number;
    }
}
