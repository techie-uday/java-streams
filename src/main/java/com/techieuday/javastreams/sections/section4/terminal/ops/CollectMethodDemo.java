package com.techieuday.javastreams.sections.section4.terminal.ops;

import com.techieuday.javastreams.factory.EmployeeFactory;
import com.techieuday.javastreams.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

import static com.techieuday.javastreams.constants.Constants.MEDIUM_LIMIT;

public class CollectMethodDemo {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeFactory.randomEmployees(MEDIUM_LIMIT);

        List<String> names = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println("Employee Names: " + names);

        // Collecting departments into a Set
        Set<String> departments = employees.stream()
                .map(Employee::getDepartmentName)
                .collect(Collectors.toSet());
        System.out.println("Departments: " + departments);

        // Collecting into a Map (ID -> Name)
        Map<Integer, String> employeeMap = employees.stream()
                .collect(Collectors.toMap(Employee::getId, Employee::getName));
        System.out.println("Employee Map: " + employeeMap);

        // Using parallel streams for performance
        List<Employee> sortedEmployees = employees.parallelStream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());
        System.out.println("Sorted Employees: " + sortedEmployees);
    }
}

