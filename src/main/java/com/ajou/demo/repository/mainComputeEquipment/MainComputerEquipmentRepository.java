package com.ajou.demo.repository.mainComputeEquipment;

import com.ajou.demo.domain.MainComputerEquipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainComputerEquipmentRepository extends JpaRepository<MainComputerEquipment, Long>, MainComputerEquipmentRepositoryCustom {

}
