package com.ajou.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.*;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Equipment {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String departmentName;

    private String operator;

    private Long contactNumber;

    private String use;

    private String modelName;

    private String equipmentName;

    //추후 추가 예정


    @Builder
    private Equipment(Long id, String departmentName, String operator, Long contactNumber, String use, String modelName, String equipmentName) {
        this.id = id;
        this.departmentName = departmentName;
        this.operator = operator;
        this.contactNumber = contactNumber;
        this.use = use;
        this.modelName = modelName;
        this.equipmentName = equipmentName;
    }
}
