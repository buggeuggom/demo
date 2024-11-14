package com.ajou.demo.service;

import com.ajou.demo.controller.request.mainComputerEquipment.MainComputerEquipmentSearch;
import com.ajou.demo.controller.response.PagingResponse;
import com.ajou.demo.controller.response.mainComputerEquipment.MainComputerEquipmentResponse;
import com.ajou.demo.domain.MainComputerEquipment;
import com.ajou.demo.repository.mainComputeEquipment.MainComputerEquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainComputerEquipmentService {

    private final MainComputerEquipmentRepository mainComputerEquipmentRepository;

    public PagingResponse<MainComputerEquipmentResponse> findBySerarchParam(MainComputerEquipmentSearch search) {

        Page<MainComputerEquipment> equipmentPage = mainComputerEquipmentRepository.getList(search);

        var response = new PagingResponse<>(equipmentPage, MainComputerEquipmentResponse.class);

        return response;
    }

}
