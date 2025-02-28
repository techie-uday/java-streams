package com.techieuday.javastreams.sections.section1;

import java.util.ArrayList;
import java.util.List;

import static com.techieuday.javastreams.utils.CommonUtils.range;

public class WhyStreams {

    public static void main(String[] args) {
        List<Integer> numbers = range(10);
        printEvenWithoutStreams(numbers);
        printEvenWithStreams(numbers);
        printUsingParallelStreams(numbers);
    }

    public static void printEvenWithoutStreams(List<Integer> numbers) {
        System.out.println("Printing even numbers without streams:");
        List<Integer> evenNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            }
        }
        System.out.println(evenNumbers);
    }

    public static void printEvenWithStreams(List<Integer> numbers) {
        System.out.println("Printing even numbers with streams:");
        numbers.stream()
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println);
    }

    public static void printUsingParallelStreams(List<Integer> numbers) {
        System.out.println("Printing even numbers using parallel streams:");
        numbers.parallelStream()
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println);
    }

}
