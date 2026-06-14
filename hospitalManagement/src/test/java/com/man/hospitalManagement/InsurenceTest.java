package com.man.hospitalManagement;

import com.man.hospitalManagement.entity.Appointment;
import com.man.hospitalManagement.entity.Insurence;
import com.man.hospitalManagement.service.AppointmentService;
import com.man.hospitalManagement.service.InsurenceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsurenceTest {

    @Autowired
    private InsurenceService insurenceService;

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testInsurenceToPatient(){
        Insurence insurence =  Insurence.builder().provider("Hdfc Agro")
                .policyNumber("Hdfc_96435")
                .validUntil(LocalDate.of(2040,1,1))
                .build();
       var updatedInsurence= insurenceService.assignInsurenceToPatient(insurence,1l);
//        System.out.println("updatedInsurence:::: "+updatedInsurence);

//        insurenceService.deletePatient(1l);
            var patient = insurenceService.removeInsurenceToPatient(1L);

    }

    @Test
    public  void testAppointment(){
        Appointment appointment= Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026,6,1,5,0,1))
                .reason("Cough")
                .build();
       var updatedAppointment= appointmentService.createANewAppointment(appointment, 1l, 2l);
    }
}
