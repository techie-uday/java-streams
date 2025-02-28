package com.techieuday.javastreams.sections.section3.intermediate.ops;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class SkipAndLimit {

    public static void main(String[] args) {
        basicSkipExample();
        basicLimitExample();
        paginationExample(2, 3);
        processLargeDataset();
    }

    private static void basicSkipExample() {
        List<Integer> numbers = IntStream.rangeClosed(1, 10)
                .boxed()
                .skip(5)
                .collect(Collectors.toList());
        System.out.println("After skip(5): " + numbers);
    }

    private static void basicLimitExample() {
        List<Integer> numbers = IntStream.rangeClosed(1, 10)
                .boxed()
                .limit(5)
                .collect(Collectors.toList());

        System.out.println("After limit(5): " + numbers);
    }

    private static void paginationExample(int page, int pageSize) {
        List<Integer> paginatedData = IntStream.rangeClosed(1, 1000)
                .boxed()
                .skip((page - 1) * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
        System.out.println("Page " + page + " Data: " + paginatedData);
    }

    private static void processLargeDataset() {
        List<String> employees = IntStream.rangeClosed(1, 1000)
                .mapToObj(i -> "Employee " + i)
                .collect(Collectors.toList());

        List<String> batch = employees.stream()
                .skip(100)
                .limit(50)
                .collect(Collectors.toList());

        System.out.println("Processing batch: " + batch.subList(0, 5) + " ...");
    }

    public static void skipMoreThanAvailable() {
        List<Integer> numbers = IntStream.rangeClosed(1, 5) // [1, 2, 3, 4, 5]
                .boxed()
                .skip(10) // Skipping more than available elements
                .collect(Collectors.toList());

        System.out.println("Result after skip(10): " + numbers); // Output: []
    }
}
