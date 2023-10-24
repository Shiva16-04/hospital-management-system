package com.assignment.hospitalmanagementsystem.transformers;

import com.assignment.hospitalmanagementsystem.entities.Patient;
import com.assignment.hospitalmanagementsystem.enums.Symptoms;
import com.assignment.hospitalmanagementsystemdtos.requestdtos.PatientRequest;
import com.assignment.hospitalmanagementsystemdtos.responsedtos.PatientResponse;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@UtilityClass
public class PatientTransformer {
    public static Patient patientRequestToPatient(PatientRequest patientRequest){
        log.info("Executing method: patientRequestToPatient (PatientTransformer package) to get the Patient entity");
        return Patient.builder()
                .name(patientRequest.getName())
                .city(patientRequest.getCity())
                .email(patientRequest.getEmail())
                .phoneNumber(patientRequest.getPhoneNumber())
                .symptom(patientRequest.getSymptom())
                .build();
    }
    public static PatientResponse patientToPatientResponse(Patient patient){
        log.info("Executing method: patientToPatientResponse (PatientTransformer package) to get the PatientResponse object");
        return PatientResponse.builder()
                .name(patient.getName())
                .city(patient.getCity())
                .email(patient.getEmail())
                .phoneNumber(patient.getPhoneNumber())
                .symptom(patient.getSymptom().getDisplayName())
                .build();
    }
}
