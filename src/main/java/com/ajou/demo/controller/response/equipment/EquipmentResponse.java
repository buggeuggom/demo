package com.ajou.demo.controller.response.equipment;

import com.ajou.demo.dto.EquipmentDto;
import lombok.Getter;

@Getter
public class EquipmentResponse {

    private Long id;

    private String departmentName;

    private String operator;

    private Long contactNumber;

    private String use;

    private String modelName;

    private String equipmentName;


    private EquipmentResponse(Long id, String departmentName, String operator, Long contactNumber, String use, String modelName, String equipmentName) {
        this.id = id;
        this.departmentName = departmentName;
        this.operator = operator;
        this.contactNumber = contactNumber;
        this.use = use;
        this.modelName = modelName;
        this.equipmentName = equipmentName;
    }

    public static EquipmentResponse of(EquipmentDto dto){
        return new EquipmentResponse(
                dto.getId(),
                dto.getDepartmentName(),
                dto.getOperator(),
                dto.getContactNumber(),
                dto.getUse(),
                dto.getModelName(),
                dto.getEquipmentName()
        );
    }
}
