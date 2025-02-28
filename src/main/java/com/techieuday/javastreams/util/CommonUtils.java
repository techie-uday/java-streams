package com.techieuday.javastreams.util;


import net.datafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CommonUtils {
    private static final Faker faker = new Faker();

    // Generates a meaningful Random Name
    public static String randomName() {
        return faker.name().fullName();
    }

    // Generates count random names with uniqueness
    public static List<String> generateRandomNames(long count) {
        return Stream.generate(CommonUtils::randomName)
                .distinct() // Ensures unique names
                .limit(count)
                .collect(Collectors.toList());
    }

    // Generates count random names that start with given prefixes
    public static List<String> nameStartsWith(long count, String... prefixes) {
        return Stream.generate(CommonUtils::randomName)
                .filter(name -> Stream.of(prefixes).anyMatch(name::startsWith))
                .distinct()
                .limit(count)
                .collect(Collectors.toList());
    }

    // Generates count random names that contain given substrings
    public static List<String> nameContains(long count, String... substrings) {
        return Stream.generate(CommonUtils::randomName)
                .filter(name -> Stream.of(substrings).anyMatch(name::contains))
                .distinct()
                .limit(count)
                .collect(Collectors.toList());
    }

    // Generates count random names that end with given suffixes
    public static List<String> namesEndsWith(long count, String... suffixes) {
        return Stream.generate(CommonUtils::randomName)
                .filter(name -> Stream.of(suffixes).anyMatch(name::endsWith))
                .distinct()
                .limit(count)
                .collect(Collectors.toList());
    }

    // Ensures at least N names start with given prefixes while maintaining randomness
    public static List<String> atLeastNNamesStartsWith(long count, int n, String... prefixes) {
        List<String> namesStartsWith = nameStartsWith(n, prefixes);
        List<String> otherNames = generateRandomNames(count - namesStartsWith.size());

        List<String> finalNames = Stream.concat(namesStartsWith.stream(), otherNames.stream())
                                        .collect(Collectors.toList());

        Collections.shuffle(finalNames);
        return finalNames;
    }

    // Generates a range of integers from start to end (exclusive)
    public static List<Integer> range(int start, int end) {
        return IntStream.range(start, end).boxed().collect(Collectors.toList());
    }

    // Generates a range from 0 to end
    public static List<Integer> range(int end) {
        return range(0, end);
    }
}
