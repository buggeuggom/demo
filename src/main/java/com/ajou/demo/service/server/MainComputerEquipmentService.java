package com.ajou.demo.service.server;

import com.ajou.demo.controller.request.maincomputerequipment.MainComputerEquipmentSearch;
import com.ajou.demo.controller.response.PagingResponse;
import com.ajou.demo.controller.response.server.MainComputerEquipmentResponse;
import com.ajou.demo.domain.server.MainComputerEquipment;
import com.ajou.demo.dto.server.MainComputerEquipmentDto;
import com.ajou.demo.exception.GlobalApplicationException;
import com.ajou.demo.repository.server.maincomputeequipment.MainComputerEquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import static com.ajou.demo.exception.ErrorCode.EQUIPMENT_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class MainComputerEquipmentService {

    private final MainComputerEquipmentRepository mainComputerEquipmentRepository;

    public PagingResponse<MainComputerEquipmentResponse> findBySerarchParam(MainComputerEquipmentSearch search) {

        Page<MainComputerEquipment> equipmentPage = mainComputerEquipmentRepository.getList(search);

        var response = new PagingResponse<>(equipmentPage, MainComputerEquipmentResponse.class);

        return response;
    }


    public MainComputerEquipmentDto findById(Long id) {

        MainComputerEquipment mainComputerEquipment = mainComputerEquipmentRepository.findById(id).orElseThrow(() -> {
            throw new GlobalApplicationException(EQUIPMENT_NOT_FOUND);
        });

        return MainComputerEquipmentDto.of(mainComputerEquipment);
    }
}
