package com.assignment.hospitalmanagementsystemdtos.requestdtos;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientRequest {
    String name;
    String symptom;
    String city;
    String phoneNumber;
    String email;
}
