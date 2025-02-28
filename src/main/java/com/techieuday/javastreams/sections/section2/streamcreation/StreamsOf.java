package com.techieuday.javastreams.sections.section2.streamcreation;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsOf {
    public static void main(String[] args) {
        streamOfInteger();
        streamOfStrings();
        streamOfPrimitive();
    }

    public static void streamOfInteger() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        stream.forEach(System.out::println);
    }

    public static void streamOfStrings() {
        Stream<String> stream = Stream.of("Techie", "Uday", "Java");
        stream.forEach(System.out::println);
    }

    public static void streamOfPrimitive() {
        int[] numbers = {1, 2, 3, 4, 5};
        IntStream stream = Arrays.stream(numbers);
        stream.forEach(System.out::println);
    }

}
