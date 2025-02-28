package com.techieuday.javastreams.model;

import java.util.Date;

public class Employee {

    private int id;
    private String name;
    private int age;
    private double salary;
    private Date joiningDate;
    private String department;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public String getDepartment() {
        return department;
    }

    public int getId() {
        return id;
    }

    private Employee(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.salary = builder.salary;
        this.joiningDate = builder.joiningDate;
        this.department = builder.department;
    }

    public static class Builder {
        private int id;
        private String name;
        private int age;
        private double salary;
        private Date joiningDate;
        private String department;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder salary(double salary) {
            this.salary = salary;
            return this;
        }

        public Builder joiningDate(Date joiningDate) {
            this.joiningDate = joiningDate;
            return this;
        }


        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder department(String department) {
            this.department = department;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }

        public static Builder create() {
            return new Builder();
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", joiningDate=" + joiningDate +
                ", department='" + department + '\'' +
                '}';
    }
}
