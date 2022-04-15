package com.midproject.schoolregistrationsystem.Enum;

public enum GradeLevel {

    FRESHMAN("Freshman");

    private final String displayValue;

    private GradeLevel(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
