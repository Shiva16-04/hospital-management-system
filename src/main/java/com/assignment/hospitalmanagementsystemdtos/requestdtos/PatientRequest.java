package com.assignment.hospitalmanagementsystemdtos.requestdtos;

import com.assignment.hospitalmanagementsystem.enums.Symptoms;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientRequest {
    String name;
    Symptoms symptom;
    String city;
    String phoneNumber;
    String email;
}
