package com.assignment.hospitalmanagementsystem.enums;

public enum Symptoms {
    ARTHRITIS("Arthritis", "Orthopedic"),
    BACK_PAIN("Back pain", "Orthopedic"),
    TISSUE_INJURIES("Tissue injuries", "Orthopedic"),
    DYSMENORRHEA("Dysmenorrhea", "Gynecology"),
    SKIN_INFECTION("Skin infection", "Dermatology"),
    SKIN_BURN("Skin burn", "Dermatology"),
    EAR_PAIN("Ear pain", "ENT Specialist");

    private final String displayName;
    private final String specialityMap;
    Symptoms (String displayName, String specialityMap){ //here the constructor is implicitly private....
        this.displayName=displayName;
        this.specialityMap=specialityMap;
    }

    public String getDisplayName(){
        return this.displayName;
    }
    public String getSpecialityMapping(){
        return this.specialityMap;
    }
}
