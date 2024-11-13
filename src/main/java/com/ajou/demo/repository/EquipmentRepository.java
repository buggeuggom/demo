package com.ajou.demo.repository;

import com.ajou.demo.domain.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

    List<Equipment> findAll();
    Optional<Equipment> findById(Long id);

}
