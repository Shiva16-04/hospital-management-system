package com.assignment.hospitalmanagementsystem.transformers;

import com.assignment.hospitalmanagementsystem.entities.Doctor;
import com.assignment.hospitalmanagementsystem.enums.City;
import com.assignment.hospitalmanagementsystem.enums.Speciality;
import com.assignment.hospitalmanagementsystemdtos.requestdtos.DoctorRequest;
import com.assignment.hospitalmanagementsystemdtos.responsedtos.DoctorResponse;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class DoctorTransformer {
    public static Doctor doctorRequestToDoctor(DoctorRequest doctorRequest){
        log.info("Executing method: doctorRequestToDoctor (in Transformer package) to get the Doctor entity");
        return Doctor.builder()
                .name(doctorRequest.getName())
                .speciality(Speciality.valueOf(doctorRequest.getSpeciality()))
                .city(City.valueOf(doctorRequest.getCity()))
                .phoneNumber(doctorRequest.getPhoneNumber())
                .email(doctorRequest.getEmail())
                .build();
    }
    public static DoctorResponse doctorToDoctorResponse(Doctor doctor){
        log.info("Executing method: doctorToDoctorResponse (in Transformer package) to get the DoctorResponse object");
        return DoctorResponse.builder()
                .name(doctor.getName())
                .speciality(doctor.getSpeciality().getDisplayName())
                .city(doctor.getCity().getDisplayName())
                .phoneNumber(doctor.getPhoneNumber())
                .email(doctor.getEmail())
                .build();
    }
}
