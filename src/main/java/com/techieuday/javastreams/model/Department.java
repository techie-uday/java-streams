package com.techieuday.javastreams.model;

public enum Department {
    IT("IT"),
    FINANCE("Finance"),
    HR("Human Resources"),
    MARKETING("Marketing"),
    SALES("Sales"),
    OPERATIONS("Operations"),
    ADMINISTRATION("Administration"),
    CUSTOMER_SUPPORT("Customer Support"),
    SOFTWARE_DEVELOPMENT("Software Development"),
    DATABASE_ADMINISTRATION("Database Administration"),
    CYBERSECURITY("Cybersecurity"),
    IT_SUPPORT("IT Support"),
    BUSINESS_DEVELOPMENT("Business Development"),
    PROCUREMENT("Procurement"),
    COMPLIANCE("Compliance"),
    PUBLIC_RELATIONS("Public Relations");

    private final String displayName;

    Department(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
