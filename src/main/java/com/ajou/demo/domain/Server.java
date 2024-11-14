package com.ajou.demo.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@NoArgsConstructor(access = PROTECTED)
public class Server {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(unique=true, updatable=false, nullable = false)
    private String serialNumber; //연번
    @Column(unique=true, updatable=false, nullable = false)
    private String vmName; //VM name
    @Column(unique=true, nullable = false)
    private String vmNameKo;

    @Column(nullable = false)
    private String hostName; //Host Name
    @Column(nullable = false)
    private String host; //Host
    @Column(nullable = false)
    private String os;  //os
    @Column(nullable = false)
    private String ipAddress; //IP Address

    private Boolean veamBackup; //Veam 백업여부

    @Builder
    private Server(Long id, String serialNumber, String vmName, String vmNameKo, String hostName, String host, String os, String ipAddress, Boolean veamBackup) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.vmName = vmName;
        this.vmNameKo = vmNameKo;
        this.hostName = hostName;
        this.host = host;
        this.os = os;
        this.ipAddress = ipAddress;
        this.veamBackup = veamBackup;
    }
}
