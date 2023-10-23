package com.assignment.hospitalmanagementsystem.controllerlayers;

import com.assignment.hospitalmanagementsystem.entities.Doctor;
import com.assignment.hospitalmanagementsystem.servicelayers.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    //Method 1: adding doctor to the db
    @PostMapping("/addDetails")
    public ResponseEntity addDetails(@RequestBody Doctor doctor){
        try {
            return new ResponseEntity(doctorService.addDetails(doctor), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}