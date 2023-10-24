package com.assignment.hospitalmanagementsystem.entities;

import com.assignment.hospitalmanagementsystem.enums.Symptoms;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "patient")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Patient {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "name", nullable = false)
    @Size(min = 3,message = "should be at least 3 characters")
    String name;
    @Column(name = "city", nullable = false)
    @Size(max=20, message = "should be at max 20 characters")
    String city;
    @Column(name = "contact_number", unique = true, nullable = false)
    @Size(min=10,message = "should be at least 10 number")
    String phoneNumber;
    @Column(name = "email", unique = true, nullable = false)
    @Email(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "should be a valid email address")
    //validating email using RFC 5322 standard
    String email;
    @Column(name = "Symptom", nullable = false)
    @Enumerated(value = EnumType.STRING)
    Symptoms symptom;
    @ManyToMany
    @JoinColumn
    List<Doctor> doctorList=new ArrayList<>();
}
