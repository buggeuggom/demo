package com.ajou.demo.dto;

import com.ajou.demo.domain.Server;
import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import static lombok.AccessLevel.*;

@Getter
public class ServerDto {

    private Long id;

    private String serialNumber; //연번
    private String vmName; //VM name
    private String vmNameKo;

    private String hostName; //Host Name
    private String host; //Host
    private String os;  //os
    private String ipAddress; //IP Address
    private Boolean veamBackup; //Veam

    @Builder(access = PRIVATE)
    private ServerDto(Long id, String serialNumber, String vmName, String vmNameKo, String hostName, String host, String os, String ipAddress, Boolean veamBackup) {
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

    public static ServerDto of(Server server) {
        return ServerDto.builder()
                .id(server.getId())
                .serialNumber(server.getSerialNumber())
                .vmName(server.getVmName())
                .vmNameKo(server.getVmNameKo())
                .hostName(server.getHostName())
                .host(server.getHost())
                .os(server.getOs())
                .ipAddress(server.getIpAddress())
                .veamBackup(server.getVeamBackup())
                .build();
    }
}
