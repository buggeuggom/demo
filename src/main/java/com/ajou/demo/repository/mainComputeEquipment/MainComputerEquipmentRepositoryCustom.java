package com.ajou.demo.repository.mainComputeEquipment;

import com.ajou.demo.controller.request.mainComputerEquipment.MainComputerEquipmentSearch;
import com.ajou.demo.domain.MainComputerEquipment;
import org.springframework.data.domain.Page;

public interface MainComputerEquipmentRepositoryCustom {

    Page<MainComputerEquipment> getList(MainComputerEquipmentSearch mainComputerEquipmentSearch);

}
