package com.ajou.demo.repository.service;

import com.ajou.demo.domain.Server;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepository extends JpaRepository<Server, Long>{

    Page<Server> findAllByOrderByIdDesc(Pageable pageable);
}
