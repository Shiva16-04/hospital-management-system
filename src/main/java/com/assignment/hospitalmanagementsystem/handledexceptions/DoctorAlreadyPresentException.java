package com.assignment.hospitalmanagementsystem.handledexceptions;

public class DoctorAlreadyPresentException extends Exception{
    public DoctorAlreadyPresentException(String message){
        super(message);
    }
}
