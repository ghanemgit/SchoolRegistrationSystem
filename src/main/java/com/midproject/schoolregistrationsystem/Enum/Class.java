package com.midproject.schoolregistrationsystem.Enum;

public enum Class {

    CLASSA("Class A"),
    CLASSB("Class B"),
    CLASSC("Class C"),
    CLASSD("Class D"),
    CLASSE("Class E");

    private final String displayValue;

    private Class(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

}
