package com.assignment.hospitalmanagementsystem.entities;

import com.assignment.hospitalmanagementsystem.enums.City;
import com.assignment.hospitalmanagementsystem.enums.Speciality;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.EnumType.STRING;

@Entity
@Table(name = "doctor")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Doctor {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name", nullable = false)
    @Size(min = 3,message = "should be at least 3 characters")
    String name;
    @Column(name = "speciality", nullable = false)
    @Enumerated(value = STRING)
    Speciality speciality;
    @Column(name = "city", nullable = false)
    @Enumerated(value = EnumType.STRING)
    City city;
    @Column(name = "contact_number", nullable = false)
    @Size(min=10,message = "should be at least 10 number")
    String phoneNumber;
    @Column(name = "email", unique = true, nullable = false)
    @Email(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "should be a valid email address")
    String email;
    @ManyToMany(mappedBy = "doctorList", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Patient> patientList=new ArrayList<>();
}
