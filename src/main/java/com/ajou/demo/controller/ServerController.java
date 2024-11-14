package com.ajou.demo.controller;

import com.ajou.demo.controller.response.PagingResponse;
import com.ajou.demo.controller.response.server.ServerListResponse;
import com.ajou.demo.service.ServerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/servers")
@RequiredArgsConstructor
public class ServerController {

    private final ServerService serverService;

    @GetMapping
    public PagingResponse<ServerListResponse> getServerList(@PageableDefault(size = 10) Pageable pageable) {

        return serverService.findAll(pageable);
    }
}
