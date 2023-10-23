package com.assignment.hospitalmanagementsystem.enums;

public enum City {
    DELHI("Delhi"),
    NOIDA("Noida"),
    FARIDABAD("Faridabad");
    private final String displayName;
    City(String displayName){
        this.displayName=displayName;
    }
    public String getDisplayName(){
        return this.displayName;
    }
}
