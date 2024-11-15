package com.ajou.demo.repository.server.maincomputeequipment;

import com.ajou.demo.controller.request.maincomputerequipment.MainComputerEquipmentSearch;
import com.ajou.demo.domain.server.MainComputerEquipment;
import org.springframework.data.domain.Page;

public interface MainComputerEquipmentRepositoryCustom {

    Page<MainComputerEquipment> getList(MainComputerEquipmentSearch mainComputerEquipmentSearch);

}
