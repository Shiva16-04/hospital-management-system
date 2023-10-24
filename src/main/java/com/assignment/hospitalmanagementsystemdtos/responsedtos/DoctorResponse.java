package com.assignment.hospitalmanagementsystemdtos.responsedtos;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorResponse {
    String name;
    String speciality;
    String city;
    String phoneNumber;
    String email;
}
