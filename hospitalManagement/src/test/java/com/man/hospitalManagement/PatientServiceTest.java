package com.man.hospitalManagement;

import java.util.List;

import com.man.hospitalManagement.dto.BloodGroupStats;
import com.man.hospitalManagement.dto.CPatientInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.man.hospitalManagement.dto.IPatientInfo;
import com.man.hospitalManagement.entity.Patient;
import com.man.hospitalManagement.repository.PatientRepository;

import lombok.var;

@SpringBootTest
public class PatientServiceTest {



    @Autowired
    public PatientRepository patientrepository;


    @Test
    public void testPatientService() {
        // Add your test cases for PatientService here
        List<BloodGroupStats> patients = patientrepository.getBloodGroupStats();

        for (var patient : patients) {
            System.out.println("patient: " + patient.getBlooadGroupType() + ", " + patient.getCount() + ", " );
        }
    }


    @Test
    public void testUpdatePatientNameById() {

        // Add your test cases for PatientService here
        int rowsUpdated =patientrepository
         .updatePatientNameById(1L, "Josh Smith");
        System.out.println("Rows updated: " + rowsUpdated);
    }
}
