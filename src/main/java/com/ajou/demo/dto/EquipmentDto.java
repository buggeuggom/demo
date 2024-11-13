package com.ajou.demo.dto;

import com.ajou.demo.domain.Equipment;
import lombok.Getter;

@Getter
public class EquipmentDto {

    private Long id;

    private String departmentName;

    private String operator;

    private Long contactNumber;

    private String use;

    private String modelName;

    private String equipmentName;

    private EquipmentDto(Long id, String departmentName, String operator, Long contactNumber, String use, String modelName, String equipmentName) {
        this.id = id;
        this.departmentName = departmentName;
        this.operator = operator;
        this.contactNumber = contactNumber;
        this.use = use;
        this.modelName = modelName;
        this.equipmentName = equipmentName;
    }

    public static EquipmentDto of(Equipment equipment) {
        return new EquipmentDto(
                equipment.getId(),
                equipment.getDepartmentName(),
                equipment.getOperator(),
                equipment.getContactNumber(),
                equipment.getUse(),
                equipment.getModelName(),
                equipment.getEquipmentName());
    }
}
