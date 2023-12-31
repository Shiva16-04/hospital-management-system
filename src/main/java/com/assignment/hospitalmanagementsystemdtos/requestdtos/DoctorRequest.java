package com.assignment.hospitalmanagementsystemdtos.requestdtos;

import com.assignment.hospitalmanagementsystem.enums.City;
import com.assignment.hospitalmanagementsystem.enums.Speciality;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorRequest {
    String name;
    String speciality;
    String city;
    String phoneNumber;
    String email;
}
