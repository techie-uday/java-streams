package com.techieuday.javastreams.sections.section4.terminal.ops;

import com.techieuday.javastreams.model.Employee;

import java.util.*;

import static com.techieuday.javastreams.constants.Constants.MEDIUM_LIMIT;
import static com.techieuday.javastreams.constants.Constants.SHORT_LIMIT;
import static com.techieuday.javastreams.factory.EmployeeFactory.randomEmployees;
import static com.techieuday.javastreams.utils.CommonUtils.randomNames;
import static com.techieuday.javastreams.utils.CommonUtils.randomNumbers;

public class ReducerDemo {

    private static final List<Integer> numbers = randomNumbers(SHORT_LIMIT);
    private static final List<String> names = randomNames(SHORT_LIMIT);
    private static final List<Employee> employees = randomEmployees(MEDIUM_LIMIT);

    public static void sumOfNumbers() {
        Optional<Integer> sum = numbers.stream().reduce(Integer::sum);
        sum.ifPresent(System.out::println);
    }

    public static void productOfNumbers() {
        long product = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(product);
    }

    public static void findLongestWord() {
        Optional<String> longestWord = names.stream()
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2);
        longestWord.ifPresent(System.out::println);
    }

    public static void sumUsingSumMethod() {
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum using sum(): " + sum);
    }

    public static void findMaxValue() {
        Optional<Integer> maxNumber = numbers.stream().reduce(Integer::max);
        maxNumber.ifPresent(System.out::println);
    }

    public static void wordCount() {
        String sentence = "Java 8 Streams are powerful";
        long wordCount = Arrays.stream(sentence.split(" ")).map(word -> 1).reduce(0, Integer::sum);
        System.out.println("Word count: " + wordCount);
    }

    public static void sumEmployeeSalaries() {
        double totalSalary = employees.stream().map(Employee::getSalary).reduce(0.0, Double::sum);
        System.out.println("Total Salary: " + totalSalary);
    }

    public static void concatenateNames() {
        String concatenatedNames = employees.stream().map(Employee::getName)
                .reduce("", (a, b) -> a + ", " + b);
        System.out.println(concatenatedNames.substring(2));
    }

    public static void parallelSum() {
        int sum = numbers.parallelStream().reduce(0, Integer::sum, Integer::sum);
        System.out.println("Parallel Sum: " + sum);
    }

    public static void main(String[] args) {
        System.out.println("--- Sum of Numbers ---");
        sumOfNumbers();

        System.out.println("\n--- Product of Numbers ---");
        productOfNumbers();

        System.out.println("\n--- Finding Longest Word ---");
        findLongestWord();

        System.out.println("\n--- Sum Using Sum Method ---");
        sumUsingSumMethod();

        System.out.println("\n--- Finding Max Value ---");
        findMaxValue();

        System.out.println("\n--- Word Count in a Sentence ---");
        wordCount();

        System.out.println("\n--- Summing Employee Salaries ---");
        sumEmployeeSalaries();

        System.out.println("\n--- Concatenating Names ---");
        concatenateNames();

        System.out.println("\n--- Parallel Sum Example ---");
        parallelSum();
    }
}

