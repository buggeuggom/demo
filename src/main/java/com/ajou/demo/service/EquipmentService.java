package com.ajou.demo.service;

import com.ajou.demo.domain.Equipment;
import com.ajou.demo.dto.EquipmentDto;
import com.ajou.demo.exception.ErrorCode;
import com.ajou.demo.exception.GlobalApplicationException;
import com.ajou.demo.repository.EquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

    public List<EquipmentDto> findAll(){
        return equipmentRepository.findAll().stream()
                .map(equipment -> EquipmentDto.of(equipment))
                .collect(Collectors.toList());
    }

    public EquipmentDto findById(Long id){

        Equipment equipment = equipmentRepository.findById(id)
                .orElseThrow(() -> new GlobalApplicationException(ErrorCode.EQUIPMENT_NOT_FOUND));

        return EquipmentDto.of(equipment);
    }
}
