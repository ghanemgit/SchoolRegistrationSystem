package com.midproject.schoolregistrationsystem.Enum;

public enum MaterialStatus {

    Single("Single"),
    Married("Married"),
    Divorced("Divorced"),
    Separated("Separated"),
    Widowed("Widowed"),
    Life_Partner("Life Partner");

    private final String displayValue;

    private MaterialStatus(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
