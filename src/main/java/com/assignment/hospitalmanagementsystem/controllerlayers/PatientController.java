package com.assignment.hospitalmanagementsystem.controllerlayers;

import com.assignment.hospitalmanagementsystem.servicelayers.DoctorService;
import com.assignment.hospitalmanagementsystem.servicelayers.PatientService;
import com.assignment.hospitalmanagementsystem.transformers.PatientTransformer;
import com.assignment.hospitalmanagementsystem.utility.EnumValidations;
import com.assignment.hospitalmanagementsystemdtos.requestdtos.PatientRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("patient")
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;

    //Method 1: adding patient to the db
    @PostMapping("/addDetails")
    public ResponseEntity addDetails(@RequestBody PatientRequest patient){
        try {
            EnumValidations.symptomCheck(patient.getSymptom());
            return new ResponseEntity(patientService.addDetails(PatientTransformer.patientRequestToPatient(patient)),
                    HttpStatus.CREATED);
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
