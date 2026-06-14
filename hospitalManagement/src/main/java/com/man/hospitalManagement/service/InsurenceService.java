package com.man.hospitalManagement.service;


import com.man.hospitalManagement.entity.Insurence;
import com.man.hospitalManagement.entity.Patient;
import com.man.hospitalManagement.repository.InsurenceRepository;
import com.man.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsurenceService {
    private  final InsurenceRepository insurenceRepository;

    private  final PatientRepository patientRepository;

    @Transactional
    public Insurence assignInsurenceToPatient (Insurence  insurence, Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurence(insurence);
        insurence.setPatient(patient);
        return insurence;
    }

    @Transactional
    public void deletePatient(Long id){
        Patient patient = patientRepository.findById(id).orElseThrow();

        patientRepository.deleteById(id);


    }

    @Transactional
    public Insurence updateInsurenceToPatient (Insurence  insurence, Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurence(insurence);
        insurence.setPatient(patient);
        return insurence;
    }
    @Transactional
    public Patient removeInsurenceToPatient ( Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurence(null);
        return patient;
    }
}
