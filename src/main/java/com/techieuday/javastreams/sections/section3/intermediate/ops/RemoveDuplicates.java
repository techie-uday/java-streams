package com.techieuday.javastreams.sections.section3.intermediate.ops;

import com.techieuday.javastreams.factory.EmployeeFactory;
import com.techieuday.javastreams.model.Employee;

import java.util.*;
import java.util.stream.Collectors;


public class RemoveDuplicates {
    public static void main(String[] args) {
        useDistinct();
        useCollectorsToSet();
        useLinkedHashSet();
        removeDuplicatesBasedOnKey();
    }

    private static void useDistinct() {
        List<Integer> numbers = List.of(1, 2, 2, 3, 4, 4, 5);
        List<Integer> uniqueNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Using distinct(): " + uniqueNumbers);
    }

    private static void useCollectorsToSet() {
        List<Integer> numbers = List.of(1, 2, 2, 3, 4, 4, 5);
        Set<Integer> uniqueSet = numbers.stream().collect(Collectors.toSet());
        System.out.println("Using Collectors.toSet(): " + uniqueSet);
    }

    private static void useLinkedHashSet() {
        List<Integer> numbers = List.of(1, 2, 2, 3, 4, 4, 5);
        List<Integer> uniqueOrderedList = new ArrayList<>(new LinkedHashSet<>(numbers));
        System.out.println("Using LinkedHashSet: " + uniqueOrderedList);
    }

    private static void removeDuplicatesBasedOnKey() {
        List<Employee> employees = EmployeeFactory.randomEmployees(10);
        List<Employee> uniqueEmployees = List.copyOf(
               employees.stream()
                        .collect(Collectors.toMap(
                                Employee::getId,
                                employee -> employee,
                                (existing, duplicate) -> existing,
                                LinkedHashMap::new
                        ))
                        .values());
        System.out.println("Removing duplicates based on a key: " + uniqueEmployees);
    }

}


