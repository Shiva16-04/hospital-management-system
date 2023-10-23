package com.assignment.hospitalmanagementsystem.handledexceptions;

public class DoctorNotFoundException extends Exception{
    DoctorNotFoundException(String message){
        super(message);
    }
}
