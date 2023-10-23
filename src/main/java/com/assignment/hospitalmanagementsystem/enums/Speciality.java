package com.assignment.hospitalmanagementsystem.enums;

import java.util.Arrays;
import java.util.List;

public enum Speciality {
    ORTHOPEDIC("Orthopedic", Arrays.asList(Symptoms.ARTHRITIS.getDisplayName(),Symptoms.BACK_PAIN.getDisplayName(),Symptoms.TISSUE_INJURIES.getDisplayName())),
    GYNECOLOGY("Gynecology", Arrays.asList(Symptoms.DYSMENORRHEA.getDisplayName())),
    DERMATOLOGY("Dermatology", Arrays.asList(Symptoms.SKIN_BURN.getDisplayName(),Symptoms.SKIN_INFECTION.getDisplayName())),
    ENT_SPECIALIST("ENT Specialist", Arrays.asList(Symptoms.EAR_PAIN.getDisplayName()));
    private final String displayName;
    private final List<String>symptoms;
    Speciality(String displayName, List<String>symptoms){ //constructor is implicitly private
        this.displayName=displayName;
        this.symptoms=symptoms;
    }

    public String getDisplayName(){
        return displayName;
    }
    public List<String> getSymptomsList(){
        return symptoms;
    }
}
