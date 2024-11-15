package com.ajou.demo.domain.server;


import jakarta.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.*;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.*;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class ServerStorageIntro {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;
    private String quantity;
    private String introductionYear;

    @ManyToOne(fetch = LAZY, optional = false)
    private MainComputerEquipment mainComputerEquipment;

    @Builder
    private ServerStorageIntro(String name, String quantity, String introductionYear, MainComputerEquipment mainComputerEquipment) {
        this.name = name;
        this.quantity = quantity;
        this.introductionYear = introductionYear;
        this.mainComputerEquipment = mainComputerEquipment;
    }


}

