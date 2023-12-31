package com.assignment.hospitalmanagementsystem.servicelayers;

import com.assignment.hospitalmanagementsystem.entities.Doctor;
import com.assignment.hospitalmanagementsystem.entities.Patient;
import com.assignment.hospitalmanagementsystem.handledexceptions.DoctorsNotAvailableAtTheLocation;
import com.assignment.hospitalmanagementsystem.handledexceptions.DoctorsNotAvailableForTheSymptom;
import com.assignment.hospitalmanagementsystem.handledexceptions.PatientAlreadyPresentException;
import com.assignment.hospitalmanagementsystem.handledexceptions.PatientNotFoundException;
import com.assignment.hospitalmanagementsystem.repositorylayers.DoctorRepository;
import com.assignment.hospitalmanagementsystem.repositorylayers.PatientRepository;
import com.assignment.hospitalmanagementsystemdtos.responsedtos.DoctorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private DoctorService doctorService;

    //Method 1: adding patient details
    public String addDetails(Patient patient) throws Exception{
        log.info("Executing method: addPatient (Patient service layer)");
        Optional<Patient>patientFromDB=patientRepository.findByEmail(patient.getEmail());
        if(patientFromDB.isPresent()){
            throw new PatientAlreadyPresentException(patient.getName()+" is already present in the database");
        }else {
            patientRepository.save(patient);
            return patient.getName() +" has been successfully added to the database";
        }
    }

    //Method 2: mapping patient to the available doctor
    public List<DoctorResponse> getAvailableDoctors(Integer patientId)throws Exception{
        log.info("Executing method: getAvailableDoctors (Patient service layer) - get the available doctors (city+symptom (Speciality))");
        Optional<Patient>patientOptional=patientRepository.findById(patientId);
        if(!patientOptional.isPresent()){
            throw new PatientNotFoundException(patientId+" is not present in the database");
        }
        Patient patient=patientOptional.get();
        //covering first edge case
        log.info("Calling Method: findByCity (Doctor service layer)");
        List<Doctor>doctorList=doctorService.findByCity(patient);
        if(doctorList.size()==0){
            throw new DoctorsNotAvailableAtTheLocation("We are still waiting to expand to your location");
        }
        //covering second edge case
        log.info("Calling Method: findBySpeciality (Doctor service layer)");
        List<DoctorResponse>doctorResponseList=doctorService.findBySpeciality(doctorList, patient);
        if(doctorResponseList.size()==0){
            throw new DoctorsNotAvailableForTheSymptom("There isn't any doctor present at your location for your symptom");
        }
        else {
            return doctorResponseList;
        }
    }

}
