package com.midproject.schoolregistrationsystem.Enum;

public enum StudentClass {

    CLASSA("Class A"),
    CLASSB("Class B"),
    CLASSC("Class C"),
    CLASSD("Class D"),
    CLASSE("Class E");

    private final String displayValue;

    private StudentClass(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

}
