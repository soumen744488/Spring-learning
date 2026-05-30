package com.man.hospitalManagement.repository;

import java.util.List;

import com.man.hospitalManagement.dto.BloodGroupStats;
import com.man.hospitalManagement.dto.CPatientInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.man.hospitalManagement.dto.IPatientInfo;
import com.man.hospitalManagement.entity.Patient;

import jakarta.transaction.Transactional;

public interface PatientRepository extends JpaRepository<Patient,Long>  {

    @Query("SELECT p.id AS id, p.name AS name, p.email AS email FROM Patient p")
    List<IPatientInfo> getAllPatientInfo();


    @Query("SELECT new com.man.hospitalManagement.dto.CPatientInfo(p.id, p.name) FROM Patient p")
    List<CPatientInfo> getallPatientInfoConcrete();


    @Query("SELECT new com.man.hospitalManagement.dto.BloodGroupStats(p.bloodGroup, COUNT(p))" +
     " FROM Patient p GROUP BY p.bloodGroup ORDER BY p.bloodGroup DESC"  )
    List<BloodGroupStats> getBloodGroupStats();

    @Modifying
    @Transactional
    @Query("UPDATE Patient p SET p.name = :name WHERE p.id = :id")
    int updatePatientNameById(@Param("id") Long id, @Param("name") String name);
}
