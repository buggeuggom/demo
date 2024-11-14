package com.ajou.demo.controller.response.server;

import com.ajou.demo.domain.Server;
import lombok.Getter;

@Getter
public class ServerListResponse {

    private Long id;

    private String serialNumber; //연번
    private String vmName; //VM name
    private String vmNameKo;

    private String hostName; //Host Name
    private String host; //Host
    private String os;  //os
    private String ipAddress; //IP Address
    private Boolean veamBackup; //Veam



    public ServerListResponse(Server server) {
        this.id = server.getId();
        this.serialNumber = server.getSerialNumber();
        this.vmName =server.getVmName();
        this.vmNameKo =server.getVmNameKo();
        this.hostName =server.getHostName();
        this.host =server.getHost();
        this.os =server.getOs();
        this.ipAddress =server.getIpAddress();
        this.veamBackup =server.getVeamBackup();
    }

    public static ServerListResponse of(Server server) {
        return new ServerListResponse(server);
    }
}
