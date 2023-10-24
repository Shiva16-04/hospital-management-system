package com.assignment.hospitalmanagementsystem.handledexceptions;

public class OutOfSpecialityListException extends RuntimeException{
    public OutOfSpecialityListException(String message){
        super(message);
    }
}
