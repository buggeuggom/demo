package com.ajou.demo.controller.server;

import com.ajou.demo.controller.request.maincomputerequipment.MainComputerEquipmentSearch;
import com.ajou.demo.controller.response.PagingResponse;
import com.ajou.demo.controller.response.server.MainComputerEquipmentResponse;
import com.ajou.demo.controller.response.server.ServerStorageIntroResponse;
import com.ajou.demo.dto.server.ServerStorageIntroDto;
import com.ajou.demo.service.server.MainComputerEquipmentService;
import com.ajou.demo.service.server.ServerStorageIntroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/main-computer-equipments")
@RequiredArgsConstructor
public class MainComputerEquipmentController {
    private final MainComputerEquipmentService mainComputerEquipmentService;
    private final ServerStorageIntroService serverStorageIntroService;

    /**
     * 페이징 긴능과 조건 기능을 가진 복수 조회
     */
    @GetMapping
    public PagingResponse<MainComputerEquipmentResponse> getMainComputerEquipment(@ModelAttribute MainComputerEquipmentSearch search) {

        return mainComputerEquipmentService.findBySerarchParam(search);
    }

    /**
     * 단건조회
     *
     * @param id
     */
    @GetMapping("/{id}")
    public MainComputerEquipmentResponse getMainComputerEquipment(@PathVariable Long id) {
        return MainComputerEquipmentResponse.of(mainComputerEquipmentService.findById(id));
    }

    @GetMapping("/{id}/server-storage-intro")
    public List<ServerStorageIntroResponse> getMainComputerEquipmentServerStorageIntro(@PathVariable Long id) {

        return serverStorageIntroService.findAllByMainComputerEquipmentId(id).stream()
                .map(ServerStorageIntroResponse::of)
                .toList();
    }

}
