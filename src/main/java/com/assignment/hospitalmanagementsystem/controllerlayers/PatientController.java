package com.assignment.hospitalmanagementsystem.controllerlayers;

import com.assignment.hospitalmanagementsystem.entities.Patient;
import com.assignment.hospitalmanagementsystem.servicelayers.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    //Method 1: adding patient to the db
    @PostMapping("/addDetails")
    public ResponseEntity addDetails(@RequestBody Patient patient){
        try {
            return new ResponseEntity(patientService.addDetails(patient), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //Method 2: mapping patient to the available doctor
    @GetMapping("/getAvailableDoctors/{patient_id}")
    public ResponseEntity getAvailableDoctors(@PathVariable("patient_id") Integer patientId){
        try {
            return new ResponseEntity<>(patientService.getAvailableDoctors(patientId),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
