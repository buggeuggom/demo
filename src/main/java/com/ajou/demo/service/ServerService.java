package com.ajou.demo.service;


import com.ajou.demo.controller.response.PagingResponse;
import com.ajou.demo.controller.response.server.ServerListResponse;
import com.ajou.demo.domain.Server;
import com.ajou.demo.dto.ServerDto;
import com.ajou.demo.repository.service.ServerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.ServerResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServerService {

    private final ServerRepository serverRepository;

    public PagingResponse<ServerListResponse> findAll(Pageable pageable) {
        Page<Server> servers = serverRepository.findAllByOrderByIdDesc(pageable);

        int totalPages = servers.getTotalPages();
        long totalElements = servers.getTotalElements();
        int pageNumber = pageable.getPageNumber();

        List<ServerListResponse> collect = servers.stream()
                .map(ServerListResponse::of)
                .collect(Collectors.toList());

        return new PagingResponse(pageNumber, totalPages, totalElements, collect);
    }
}
