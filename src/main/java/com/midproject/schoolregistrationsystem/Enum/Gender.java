package com.midproject.schoolregistrationsystem.Enum;

public enum Gender {

    Male("Male"),Female("Female");

    private final String displayValue;

    private Gender(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
