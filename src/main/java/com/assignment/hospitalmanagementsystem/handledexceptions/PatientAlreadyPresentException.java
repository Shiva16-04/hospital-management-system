package com.assignment.hospitalmanagementsystem.handledexceptions;

public class PatientAlreadyPresentException extends Exception{
    public PatientAlreadyPresentException(String message){
        super(message);
    }
}
