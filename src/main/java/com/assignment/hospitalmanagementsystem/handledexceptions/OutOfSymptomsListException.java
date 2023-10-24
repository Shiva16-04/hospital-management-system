package com.assignment.hospitalmanagementsystem.handledexceptions;

public class OutOfSymptomsListException extends RuntimeException{
    public OutOfSymptomsListException(String message){
        super(message);
    }
}
