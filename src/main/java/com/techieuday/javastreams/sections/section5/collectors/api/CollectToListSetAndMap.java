package com.techieuday.javastreams.sections.section5.collectors.api;

import com.techieuday.javastreams.factory.EmployeeFactory;
import com.techieuday.javastreams.model.Department;
import com.techieuday.javastreams.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class CollectToListSetAndMap {


    private static final List<Employee> uniqueEmployees = EmployeeFactory.randomEmployees(1000);
    private static final List<Employee> employeesWithDuplicates = EmployeeFactory.randomEmployeesWithDuplicates(1000, 300, 15);
    private static final List<String> names = employeesWithDuplicates.stream().map(Employee::getName).toList();

    public static void main(String[] args) {
        collectToList();
        collectToSet();
        collectToMap();
        collectToUnmodifiableList();
        collectToUnmodifiableSet();
        collectToUnmodifiableMap();
        collectToConcurrentMap();
        collectToSpecificCollection();
        handleDuplicateKeys();
    }

    private static void collectToList() {
        List<String> namesStartsWithA = names.stream()
                .filter(n -> n.startsWith("A")).collect(Collectors.toList());
        System.out.println("Names Starts With A: " + namesStartsWithA);
    }

    private static void collectToSet() {
        Set<String> uniqueNamesStartsWithA = names.stream()
                .filter(n -> n.startsWith("A")).collect(Collectors.toSet());
        System.out.println("Unique Names Starts With A: " + uniqueNamesStartsWithA);
    }

    private static void collectToMap() {
        Map<Integer, String> idToNameMap = uniqueEmployees.stream()
                .collect(Collectors.toMap(Employee::getId, Employee::getName));
        System.out.println("Map Example: " + idToNameMap);
    }

    private static void collectToUnmodifiableList() {
        List<String> namesStartsWithB = names.stream()
                .filter(n -> n.startsWith("B")).collect(Collectors.toUnmodifiableList());
        System.out.println("Unmodifiable List: " + namesStartsWithB);
    }

    private static void collectToUnmodifiableSet() {
        Set<String> uniqueNamesStartsWithB = names.stream()
                .filter(n -> n.startsWith("B")).collect(Collectors.toUnmodifiableSet());
        System.out.println("Unmodifiable Set: " + uniqueNamesStartsWithB);
    }

    private static void collectToUnmodifiableMap() {
        Map<Integer, String> idToNameUnmodifiableMap = uniqueEmployees.stream()
                .collect(Collectors.toUnmodifiableMap(Employee::getId, Employee::getName));
        System.out.println("Unmodifiable Map Example: " + idToNameUnmodifiableMap);
    }

    private static void collectToConcurrentMap() {
        Map<Integer, String> idToNameConcurrentMap = uniqueEmployees.parallelStream()
                .collect(Collectors.toConcurrentMap(Employee::getId, Employee::getName));
        System.out.println("Concurrent Map Example: " + idToNameConcurrentMap);
    }
    private static void handleDuplicateKeys() {

        Map<String, Integer> empCount = employeesWithDuplicates.stream().map(Employee::getName)
                .collect(Collectors.toMap(
                        s -> s,
                        s -> 1,
                        Integer::sum
                ));

        System.out.println("Handling Duplicate Keys: " + empCount);
    }

    private static void collectToSpecificCollection() {
        List<String> arrayList = uniqueEmployees.stream()
                .filter(emp -> emp.getDepartment() == Department.ADMINISTRATION)
                .map(Employee::getName)
                .collect(Collectors.toCollection(ArrayList::new));

        Set<String> hashSet = uniqueEmployees.stream()
                .filter(emp -> emp.getDepartment() == Department.ADMINISTRATION)
                .map(Employee::getName).collect(Collectors.toSet());

        Set<String> linkedHashSet = uniqueEmployees.stream()
                .filter(emp -> emp.getDepartment() == Department.ADMINISTRATION)
                .map(Employee::getName)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<String> treeHashSet = uniqueEmployees.stream()
                .filter(emp -> emp.getDepartment() == Department.ADMINISTRATION)
                .map(Employee::getName)
                .collect(Collectors.toCollection(TreeSet::new));

        System.out.println("toCollection Example (HashSet): " + hashSet);
        System.out.println("toCollection Example (ArrayList): " + arrayList);
        System.out.println("toCollection Example (LinkedHashSet): " + linkedHashSet);
        System.out.println("toCollection Example (TreeSet): " + treeHashSet);
    }

}
