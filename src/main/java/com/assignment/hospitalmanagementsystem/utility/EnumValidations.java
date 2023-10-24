package com.assignment.hospitalmanagementsystem.utility;

import com.assignment.hospitalmanagementsystem.enums.City;
import com.assignment.hospitalmanagementsystem.enums.Speciality;
import com.assignment.hospitalmanagementsystem.enums.Symptoms;
import com.assignment.hospitalmanagementsystem.handledexceptions.OutOfCityListException;
import com.assignment.hospitalmanagementsystem.handledexceptions.OutOfSpecialityListException;
import com.assignment.hospitalmanagementsystem.handledexceptions.OutOfSymptomsListException;

public class EnumValidations {
    public static boolean cityCheck(String city)throws RuntimeException{
        for(City cityValue:City.values()){
            if(cityValue.toString().equals(city))return true;
        }
        String cityAns=String.valueOf(City.DELHI)+", "+String.valueOf(City.FARIDABAD)+", "+String.valueOf(City.NOIDA);
        throw new OutOfCityListException("Doctor should be from one of these cities: \n"+cityAns);
    }
    public static boolean specialityCheck(String speciality)throws RuntimeException{
        for(Speciality specialityValue: Speciality.values()){
            if(specialityValue.toString().equals(speciality))return true;
        }
        String specialitiesAns=String.valueOf(Speciality.ORTHOPEDIC)+", "+String.valueOf(Speciality.DERMATOLOGY)+", "+
                String.valueOf(Speciality.GYNECOLOGY)+", "+String.valueOf(Speciality.ENT_SPECIALIST);
        throw new OutOfSpecialityListException("Doctor's Speciality should be one of these: \n"+specialitiesAns);
    }
    public static boolean symptomCheck(String symptom)throws RuntimeException{
        for(Symptoms symptomValue: Symptoms.values()){
            if(symptomValue.toString().equals(symptom))return true;
        }
        String symptomsAns=String.valueOf(Symptoms.ARTHRITIS)+", "+String.valueOf(Symptoms.BACK_PAIN)+", "+
                String.valueOf(Symptoms.TISSUE_INJURIES)+", "+ String.valueOf(Symptoms.DYSMENORRHEA)+", "+
                String.valueOf(Symptoms.SKIN_BURN)+", "+ String.valueOf(Symptoms.SKIN_INFECTION)+", "+
                String.valueOf(Symptoms.EAR_PAIN);
        throw new OutOfSymptomsListException("At present Doctor can treat for one of these patient symptoms: \n"+symptomsAns);
    }
}
