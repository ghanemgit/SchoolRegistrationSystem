package com.midproject.schoolregistrationsystem.Enum;

public enum MaritalState {

    Single("Single"),
    Married("Married"),
    Divorced("Divorced"),
    Separated("Separated"),
    Widowed("Widowed"),
    Life_Partner("Life Partner");

    private final String displayValue;

    private MaritalState(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
