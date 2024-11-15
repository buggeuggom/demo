package com.ajou.demo.repository.server.maincomputeequipment;

import com.ajou.demo.domain.server.MainComputerEquipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MainComputerEquipmentRepository extends JpaRepository<MainComputerEquipment, Long>, MainComputerEquipmentRepositoryCustom {

    Optional<MainComputerEquipment> findMainComputerEquipmentById(Long id);
}
