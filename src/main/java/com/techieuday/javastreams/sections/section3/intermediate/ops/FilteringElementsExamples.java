package com.techieuday.javastreams.sections.section3.intermediate.ops;
// Filtering Elements in Java 8 Streams
import com.techieuday.javastreams.factory.EmployeeFactory;
import com.techieuday.javastreams.model.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.techieuday.javastreams.factory.EmployeeFactory.randomEmployeeBuilder;
import static com.techieuday.javastreams.utils.CommonUtils.range;

public class FilteringElementsExamples {

    public static void main(String[] args) {
        // Basic Filtering: Even Numbers
        System.out.println("Filtering Even Numbers:");
        List<Integer> numbers = range(20);
        List<Integer> evenNumbers = numbers.stream()
                                           .filter(n -> n % 2 == 0)
                                           .collect(Collectors.toList());
        System.out.println(evenNumbers); // Output: [2, 4, 6, 8, 10]

        // Filtering Primitive Stream: Odd Numbers
        System.out.println("\nFiltering Odd Numbers in IntStream:");
        IntStream.range(1, 11)
                 .filter(n -> n % 2 != 0)
                 .forEach(System.out::println); // Output: 1, 3, 5, 7, 9

        // Filtering with Multiple Conditions
        System.out.println("\nFiltering Numbers > 5 and Even:");
        List<Integer> filteredNumbers = numbers.stream()
                                               .filter(n -> n > 5 && n % 2 == 0)
                                               .collect(Collectors.toList());
        System.out.println(filteredNumbers); // Output: [6, 8, 10]

        // Removing Null & Empty Strings
        System.out.println("\nRemoving Null & Empty Strings:");
        List<String> names = Arrays.asList("Alice", "", null, "Bob", "Charlie", "");
        List<String> nonEmptyNames = names.stream()
                                          .filter(name -> name != null && !name.isEmpty())
                                          .collect(Collectors.toList());
        System.out.println(nonEmptyNames); // Output: [Alice, Bob, Charlie]

        // Filtering Custom Objects (Employees with Salary > 50,000)
        System.out.println("\nFiltering Employees with Salary > 50,000:");

        List<Employee> employees = new ArrayList<>();
        employees.add(randomEmployeeBuilder().salary(50000).build());
        employees.add(randomEmployeeBuilder().salary(20000).build());
        employees.add(randomEmployeeBuilder().salary(60000).build());
        employees.add(randomEmployeeBuilder().salary(35000).build());
        employees.add(randomEmployeeBuilder().salary(45000).build());
        employees.add(randomEmployeeBuilder().salary(80000).build());

        employees = EmployeeFactory.createEmployees(10_000_000);

        List<Employee> highPaidEmployees = employees.stream()
                                                    .filter(e -> e.getSalary() > 50000)
                                                    .collect(Collectors.toList());
        System.out.println(highPaidEmployees);

        // Filtering Unique Elements Using distinct()
        System.out.println("\nFiltering Unique Elements (Distinct without equals & hashCode):");
        List<Employee> duplicateEmployees = new ArrayList<>();

        Employee emp = EmployeeFactory.randomEmployee();
        duplicateEmployees.add(emp);
        duplicateEmployees.add(EmployeeFactory.copy(emp));
        duplicateEmployees.add(EmployeeFactory.copy(emp));
        duplicateEmployees.add(EmployeeFactory.copy(emp));

        List<Employee> uniqueEmployees = duplicateEmployees.stream()
                                                           .distinct()
                                                           .collect(Collectors.toList());
        System.out.println(uniqueEmployees);
    }
}
