package com.techieuday.javastreams.service;


import net.datafaker.Faker;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FakerService {
    private FakerService() {}
    private static final Faker faker = new Faker();
    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static int getId(){
        return faker.number().positive();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getFullName() {
        return faker.name().fullName();
    }

    public static String getEmail() {
        return faker.internet().emailAddress();
    }

    public static String getPhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }

    public static String getAddress() {
        return faker.address().fullAddress();
    }

    public static String getCompany() {
        return faker.company().name();
    }

    public static String getJobTitle() {
        return faker.job().title();
    }

    public static String getFruit() {
        return faker.food().fruit();
    }

    public static int getAge() {
        return faker.number().numberBetween(19, 60);
    }

    public static String getQuote() {
        return faker.chuckNorris().fact();
    }
    
    public static String getDepartment() {
        return faker.company().industry();
    }

    public static Date getJoiningDate() {
        return Date.from(faker.timeAndDate().past(365 * 20, 100, TimeUnit.DAYS));
    }

    public static double getSalary() {
        return faker.number().randomDouble(0, 15, 500) * 1000;
    }

}
