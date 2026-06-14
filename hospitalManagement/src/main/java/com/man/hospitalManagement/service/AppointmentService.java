package com.man.hospitalManagement.service;

import com.man.hospitalManagement.entity.Appointment;
import com.man.hospitalManagement.entity.Doctor;
import com.man.hospitalManagement.entity.Patient;
import com.man.hospitalManagement.repository.AppointmentRepository;
import com.man.hospitalManagement.repository.DoctorRepository;
import com.man.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createANewAppointment(Appointment appointment, Long PId, Long dId){
        Patient patient= patientRepository.findById(PId).orElseThrow();

        Doctor doctor = doctorRepository.findById(dId).orElseThrow();;

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        appointmentRepository.save(appointment);
        return appointment;
    }
}
