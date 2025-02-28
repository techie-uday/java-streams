package com.techieuday.javastreams.factory;

import com.techieuday.javastreams.model.Employee;

import java.util.List;
import java.util.stream.Stream;

import static com.techieuday.javastreams.service.FakerService.*;

public class EmployeeFactory {
    private EmployeeFactory() {}
    public static Employee createEmployee() {
        return Employee.Builder.create().build();
    }

    public static Employee.Builder employeeBuilder() {
        return Employee.Builder.create();
    }

    public static Employee.Builder randomEmployeeBuilder() {
        return employeeBuilder()
                .age(getAge())
                .name(getFullName())
                .salary(getSalary())
                .joiningDate(getJoiningDate())
                .department(getDepartment())
                .id(getId());
    }

    public static Employee randomEmployee() {
        return randomEmployeeBuilder().build();
    }

    public static List<Employee> createEmployees(long count) {
        return Stream.generate(EmployeeFactory::createEmployee).limit(count).toList();
    }

    public static List<Employee> randomEmployees(long count) {
        return Stream.generate(EmployeeFactory::randomEmployee).limit(count).toList();
    }

    public static Employee copy(Employee employee) {
        return Employee.Builder.create()
                .age(employee.getAge())
                .name(employee.getName())
                .salary(employee.getSalary())
                .department(employee.getDepartment())
                .id(employee.getId())
                .joiningDate(employee.getJoiningDate())
                .build();
    }

}
