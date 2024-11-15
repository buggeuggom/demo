package com.ajou.demo.service.server;

import com.ajou.demo.domain.server.MainComputerEquipment;
import com.ajou.demo.dto.server.ServerStorageIntroDto;
import com.ajou.demo.exception.GlobalApplicationException;
import com.ajou.demo.repository.server.ServerStorageIntroRepository;
import com.ajou.demo.repository.server.maincomputeequipment.MainComputerEquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.ajou.demo.exception.ErrorCode.EQUIPMENT_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ServerStorageIntroService {

    private final MainComputerEquipmentRepository mainComputerEquipmentRepository;
    private final ServerStorageIntroRepository serverStorageIntroRepository;

    @Transactional(readOnly = true)
    public List<ServerStorageIntroDto> findAllByMainComputerEquipmentId(Long mainComputerEquipmentId) {

        MainComputerEquipment mainComputerEquipment = mainComputerEquipmentRepository.findById(mainComputerEquipmentId).orElseThrow(() -> {
            throw new GlobalApplicationException(EQUIPMENT_NOT_FOUND);
        });

        List<ServerStorageIntroDto> collect = serverStorageIntroRepository.findAllByMainComputerEquipment(mainComputerEquipment)
                .stream().map(entity -> ServerStorageIntroDto.of(entity))
                .collect(Collectors.toList());

        return collect;
    }

}
