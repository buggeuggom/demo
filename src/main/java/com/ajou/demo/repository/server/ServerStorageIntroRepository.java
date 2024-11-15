package com.ajou.demo.repository.server;

import com.ajou.demo.domain.server.MainComputerEquipment;
import com.ajou.demo.domain.server.ServerStorageIntro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServerStorageIntroRepository extends JpaRepository<ServerStorageIntro, Long> {

    List<ServerStorageIntro> findAllByMainComputerEquipment(MainComputerEquipment mainComputerEquipment);
}
