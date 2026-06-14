package com.man.hospitalManagement.repository;

import com.man.hospitalManagement.entity.Insurence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsurenceRepository extends JpaRepository<Insurence, Long> {
}