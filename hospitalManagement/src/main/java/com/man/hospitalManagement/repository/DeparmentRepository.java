package com.man.hospitalManagement.repository;

import com.man.hospitalManagement.entity.Deparment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeparmentRepository extends JpaRepository<Deparment, Long> {
}