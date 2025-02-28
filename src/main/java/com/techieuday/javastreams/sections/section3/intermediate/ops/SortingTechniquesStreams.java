package com.techieuday.javastreams.sections.section3.intermediate.ops;

import com.techieuday.javastreams.factory.EmployeeFactory;
import com.techieuday.javastreams.models.Employee;

import java.util.*;

import static com.techieuday.javastreams.utils.CommonUtils.generateRandomNames;


public class SortingTechniquesStreams {

    public static void main(String[] args) {

        List<String> names = generateRandomNames(15);
        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 7);
        List<Employee> employees = EmployeeFactory.randomEmployees(20);

        // Default Sorting (Natural Order - Lexicographic)
        System.out.println("Default Sorting (Natural Order):");
        names.stream().sorted().forEach(System.out::println);

        // Reverse Sorting (Descending Order)
        System.out.println("\nReverse Sorting (Descending Order):");
        numbers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        // Sorting Custom Objects by Age
        System.out.println("\nSorting Custom Objects by Age:");
        employees.stream().sorted(Comparator.comparing(Employee::getAge))
                 .forEach(System.out::println);

        // Sorting with Multiple Conditions (By Age, then Name)
        System.out.println("\nSorting by Age, then Name:");
        employees.stream()
                 .sorted(Comparator.comparing(Employee::getAge)
                 .thenComparing(Employee::getName))
                 .forEach(System.out::println);

        // Sorting with a Custom Comparator (By Name Length)
        System.out.println("\nSorting by Name Length:");
        employees.stream()
                 .sorted(Comparator.comparing(e -> e.getName().length()))
                 .forEach(System.out::println);

        // Efficient Sorting for Large Streams: Sorting and Limiting
        System.out.println("\nEfficient Sorting: Sorting and Keeping Only Top 2 by Age:");
        employees.stream()
                 .sorted(Comparator.comparing(Employee::getAge))
                 .limit(2) // Keeping only the top 2 employees by age
                 .forEach(System.out::println);
    }
}
