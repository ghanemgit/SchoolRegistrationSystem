package com.midproject.schoolregistrationsystem.Enum;

public enum Department {

    Finance("Finance"), Administrative("Administrative"), HR("HR"), QA("QA"),
    Academic("Academic"), Admission_and_Registration("Admission and Registration");

    private final String displayValue;

    private Department(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
