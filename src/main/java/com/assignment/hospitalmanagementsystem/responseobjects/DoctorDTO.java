package com.assignment.hospitalmanagementsystem.responseobjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {
    String name;
    String speciality;
    String city;
    String phoneNumber;
    String email;
}
