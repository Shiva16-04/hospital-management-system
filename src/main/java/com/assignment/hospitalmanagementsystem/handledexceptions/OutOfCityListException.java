package com.assignment.hospitalmanagementsystem.handledexceptions;

public class OutOfCityListException extends RuntimeException{
    public OutOfCityListException(String message){
        super(message);
    }
}
