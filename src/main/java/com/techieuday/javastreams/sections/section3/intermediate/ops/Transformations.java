package com.techieuday.javastreams.sections.section3.intermediate.ops;

import com.techieuday.javastreams.factory.EmployeeFactory;
import com.techieuday.javastreams.model.Employee;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Transformations {
    public static void main(String[] args) {
        demonstrateMap();
        demonstrateFlatMap();
        demonstrateCollectingTransformedData();
    }

    private static void demonstrateMap() {
        // Example of map() - Squaring numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Squared Numbers: " + squares);
    }

    private static void demonstrateFlatMap() {
        // Example of flatMap() - Flattening nested lists
        List<List<String>> names = Arrays.asList(
                Arrays.asList("John", "Jane"),
                Arrays.asList("Alice", "Bob")
        );
        List<String> flatList = names.stream()
                .flatMap(Collection::stream)
                .toList();
        System.out.println("Flattened List: " + flatList);
    }

    private static void demonstrateCollectingTransformedData() {
        // Example of collecting transformed data
        List<Employee> employees = EmployeeFactory.randomEmployees(10);
        List<String> employeeNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println("Employee Names: " + employeeNames);
    }
}
