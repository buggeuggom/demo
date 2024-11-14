package com.ajou.demo.controller;

import com.ajou.demo.controller.request.mainComputerEquipment.MainComputerEquipmentSearch;
import com.ajou.demo.controller.response.PagingResponse;
import com.ajou.demo.controller.response.mainComputerEquipment.MainComputerEquipmentResponse;
import com.ajou.demo.service.MainComputerEquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/main-computer-equipments")
@RequiredArgsConstructor
public class MainComputerEquipmentController {
    private final MainComputerEquipmentService mainComputerEquipmentService;

    /**
     * 페이징 긴능과 조건 기능을 가진 복수 조회
     */
    @GetMapping
    public PagingResponse<MainComputerEquipmentResponse> getMainComputerEquipment(@ModelAttribute MainComputerEquipmentSearch search) {

        return mainComputerEquipmentService.findBySerarchParam(search);
    }

    /**
     * 단건조회
     * @param id
     */
    @GetMapping("/{id}")
    public void getMainComputerEquipment(@PathVariable Long id) {

    }

}
