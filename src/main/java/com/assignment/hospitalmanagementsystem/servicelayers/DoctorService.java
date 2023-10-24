package com.assignment.hospitalmanagementsystem.servicelayers;

import com.assignment.hospitalmanagementsystem.entities.Doctor;
import com.assignment.hospitalmanagementsystem.entities.Patient;
import com.assignment.hospitalmanagementsystem.handledexceptions.DoctorAlreadyPresentException;
import com.assignment.hospitalmanagementsystem.repositorylayers.DoctorRepository;
import com.assignment.hospitalmanagementsystem.transformers.DoctorTransformer;
import com.assignment.hospitalmanagementsystemdtos.responsedtos.DoctorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    //Method 1: adding doctor details
    public String addDetails(@RequestBody Doctor doctor)throws Exception{
        log.info("Executing method: addDoctor (Doctor service layer)");
        Optional<Doctor> doctorFromDB=doctorRepository.findByEmail(doctor.getEmail());
        if(doctorFromDB.isPresent()){
            throw new DoctorAlreadyPresentException(doctor.getName()+"'s information is already present in the database");
        }else {
            doctorRepository.save(doctor);
            return "Doctor "+doctor.getName() + "'s information has been successfully added to the database";
        }
    }

    //General methods

    //Method to filter out the list of doctors that matches with the same location of the patient
    public List<Doctor> findByCity(Patient patient){
        log.info("Executing method: findByCity (Doctor service layer) - list of doctor entities - city based ");
        List<Doctor>doctorList=doctorRepository.findAll(); //getting the whole list of doctors
        List<Doctor>doctorResponseList=new ArrayList<>();
        String patientCity=patient.getCity();
        for(Doctor doctor:doctorList){
            if(doctor.getCity().getDisplayName().equalsIgnoreCase(patientCity)){
                doctorResponseList.add(doctor);
            }
        }
        return doctorResponseList; //returning the final list of doctors whose location matches patient
    }
    //Method to find the final list of doctors that matches the speciality with patient symptom speciality matching
    public List<DoctorResponse> findBySpeciality(List<Doctor>doctorList, Patient patient){
        log.info("Executing method: findBySpeciality (Doctor service layer)- list of doctor DTO - city based->(filtering out)->speciality based");
        List<DoctorResponse>doctorResponseList=new ArrayList<>();
        for(Doctor doctor:doctorList){  //doctors list is having info of doctors whose location matches with patient
            String doctorSpeciality=doctor.getSpeciality().getDisplayName();
            String matchingPatientSpeciality=patient.getSymptom().getSpecialityMapping();
            if(doctorSpeciality.equalsIgnoreCase(matchingPatientSpeciality)) {
                doctorResponseList.add(DoctorTransformer.doctorToDoctorResponse(doctor));
            }
        }
        return doctorResponseList;  //filtered list with the list of doctors where patients' symptom-speciality map is matching
        // with the  doctor's speciality
    }

}
