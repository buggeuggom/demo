package com.ajou.demo.controller.response.mainComputerEquipment;

import com.ajou.demo.domain.MainComputerEquipment;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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
}
