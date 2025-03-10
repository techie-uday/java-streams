package com.techieuday.javastreams.sections.section4.terminal.ops;

import com.techieuday.javastreams.model.Employee;

import java.util.*;

import static com.techieuday.javastreams.constants.Constants.MEDIUM_LIMIT;
import static com.techieuday.javastreams.factory.EmployeeFactory.randomEmployeeBuilder;
import static com.techieuday.javastreams.factory.EmployeeFactory.randomEmployees;
import static com.techieuday.javastreams.utils.CommonUtils.randomNames;
import static com.techieuday.javastreams.utils.CommonUtils.randomNumbers;

public class FindingElementsExample {
    public static void main(String[] args) {
        List<String> names = randomNames(MEDIUM_LIMIT);
        List<Integer> numbers = randomNumbers(MEDIUM_LIMIT);
        List<Employee> employees = new ArrayList<>(randomEmployees(MEDIUM_LIMIT));

        employees.add(randomEmployeeBuilder().id(2).name("Uday").build());

        // 1. findFirst()
        Optional<String> firstName = names.stream().findFirst();
        firstName.ifPresent(name -> System.out.println("First Name: " + name));

        // 2. findAny()
        Optional<String> anyName = names.parallelStream().findAny();
        anyName.ifPresent(name -> System.out.println("Any Name: " + name));

        // 3. anyMatch()
        boolean hasUday = names.stream().anyMatch(name -> name.equals("Uday"));
        System.out.println("Contains Uday: " + hasUday);

        // 4. allMatch()
        boolean allEven = numbers.stream().allMatch(n -> n % 2 == 0);
        System.out.println("All Even: " + allEven);

        // 5. noneMatch()
        boolean noneOdd = numbers.stream().noneMatch(n -> n % 2 != 0);
        System.out.println("No Odd Numbers: " + noneOdd);

        // 6. min() and max()
        Optional<Integer> minAge = numbers.stream().min(Integer::compare);
        Optional<Integer> maxAge = numbers.stream().max(Integer::compare);
        minAge.ifPresent(age -> System.out.println("Min Age: " + age));
        maxAge.ifPresent(age -> System.out.println("Max Age: " + age));

        // 7. Finding an Employee
        Optional<Employee> employee = employees.stream().filter(e -> e.getId() == 2).findAny();
        employee.ifPresent(e -> System.out.println("Found Employee: " + e.getName()));
    }
}
