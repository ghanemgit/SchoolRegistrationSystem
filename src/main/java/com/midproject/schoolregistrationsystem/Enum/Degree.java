package com.midproject.schoolregistrationsystem.Enum;

public enum Degree {

    JUSTSTUDENT("Just a student"),
    DIPLOMA("Diploma"),
    BACHELOR("Bachelor"),
    MASTER("Master"),
    DOCTORATE("Doctorate");

    private final String displayValue;

    private Degree(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
