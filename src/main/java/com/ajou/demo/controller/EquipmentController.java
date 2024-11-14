package com.ajou.demo.controller;

import com.ajou.demo.controller.response.equipment.EquipmentListResponse;
import com.ajou.demo.controller.response.equipment.EquipmentResponse;
import com.ajou.demo.dto.EquipmentDto;
import com.ajou.demo.service.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/equipments")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;

    @GetMapping()
    public List<EquipmentListResponse> findAll() {
        List<EquipmentListResponse> listResponses = equipmentService.findAll().stream()
                .map(dto -> EquipmentListResponse.of(dto))
                .collect(Collectors.toList());
        return listResponses;
    }

    @GetMapping("/{id}")
    public EquipmentResponse findById(@PathVariable Long id) {
        EquipmentDto equipmentDto = equipmentService.findById(id);
        return EquipmentResponse.of(equipmentDto);
    }

}
