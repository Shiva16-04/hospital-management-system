package com.assignment.hospitalmanagementsystem.controllerlayers;

import com.assignment.hospitalmanagementsystem.servicelayers.DoctorService;
import com.assignment.hospitalmanagementsystem.transformers.DoctorTransformer;
import com.assignment.hospitalmanagementsystem.utility.EnumValidations;
import com.assignment.hospitalmanagementsystemdtos.requestdtos.DoctorRequest;
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
    public ResponseEntity addDetails(@RequestBody DoctorRequest doctor){
        try {
            EnumValidations.cityCheck(doctor.getCity());
            EnumValidations.specialityCheck(doctor.getSpeciality());
            return new ResponseEntity(doctorService.addDetails(DoctorTransformer.doctorRequestToDoctor(doctor)), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}
