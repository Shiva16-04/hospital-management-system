package com.assignment.hospitalmanagementsystemdtos.responsedtos;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientResponse {
    String name;
    String symptom;
    String city;
    String phoneNumber;
    String email;
}
