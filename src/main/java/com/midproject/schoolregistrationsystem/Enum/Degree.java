package com.midproject.schoolregistrationsystem.Enum;

public enum Degree {

    Just_a_Student("Just a student"),
    Diploma("Diploma"),
    Bachelor("Bachelor"),
    Master("Master"),
    Doctorate("Doctorate");

    private final String displayValue;

    private Degree(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
