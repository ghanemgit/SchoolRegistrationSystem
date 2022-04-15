package com.midproject.schoolregistrationsystem.Enum;

public enum MaterialStatus {

    SINGLE("Single"),
    MARRIED("Married"),
    DIVORCED("Divorced"),
    SEPARATED("Separated"),
    WIDOWED("Widowed"),
    LIFE_PARTNER("Life Partner");

    private final String displayValue;

    private MaterialStatus(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
