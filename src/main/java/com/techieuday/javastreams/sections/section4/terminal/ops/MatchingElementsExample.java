package com.techieuday.javastreams.sections.section4.terminal.ops;

import com.techieuday.javastreams.model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static com.techieuday.javastreams.constants.Constants.MEDIUM_LIMIT;
import static com.techieuday.javastreams.factory.EmployeeFactory.randomEmployee;
import static com.techieuday.javastreams.factory.EmployeeFactory.randomEmployees;
import static com.techieuday.javastreams.utils.CommonUtils.randomNumbers;

public class MatchingElementsExample {
    public static void main(String[] args) {
        List<Integer> numbers = randomNumbers(MEDIUM_LIMIT);
        List<Employee> employees = randomEmployees(MEDIUM_LIMIT);

        boolean anyHighSalary = employees.stream().anyMatch(emp -> emp.getSalary() > 7500);
        System.out.println("Any employee earns more than 7500? " + anyHighSalary);

        boolean allAdults = employees.stream().allMatch(emp -> emp.getAge() >= 18);
        System.out.println("Are all employees adults? " + allAdults);

        boolean noTeenagers = employees.stream().noneMatch(emp -> emp.getAge() < 18);
        System.out.println("Are there no teenage employees? " + noTeenagers);

        List<Integer> emptyList = List.of();
        boolean emptyAllMatch = emptyList.stream().allMatch(n -> n > 10);
        boolean emptyAnyMatch = emptyList.stream().anyMatch(n -> n > 10);
        boolean emptyNoneMatch = emptyList.stream().noneMatch(n -> n > 10);

        System.out.println("Empty stream - allMatch: " + emptyAllMatch);
        System.out.println("Empty stream - anyMatch: " + emptyAnyMatch);
        System.out.println("Empty stream - noneMatch: " + emptyNoneMatch);

        long start = System.nanoTime();
        boolean parallelMatch = IntStream.range(1, 1_000_000).parallel().anyMatch(n -> n == 999_999);
        long end = System.nanoTime();
        System.out.println("Parallel anyMatch time: " + (end - start) + " ns");
    }
}
